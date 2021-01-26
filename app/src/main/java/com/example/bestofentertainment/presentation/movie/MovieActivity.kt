package com.example.bestofentertainment.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bestofentertainment.R
import com.example.bestofentertainment.data.model.movie.Movie
import com.example.bestofentertainment.databinding.ActivityMovieBinding
import com.example.bestofentertainment.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieActivityViewModelFactory
    private lateinit var movieViewModel: MovieActivityViewModel
    private lateinit var adapter: MovieAdapter
    private lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        (application as Injector).createMovieComponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this,factory).get(MovieActivityViewModel::class.java)

        initRecyclerView()


        binding.movieFloatingActionButton.setOnClickListener{
            binding.movieProgressBar.visibility = View.VISIBLE
            updateMovies()
        }

    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){

        binding.movieProgressBar.visibility = View.VISIBLE

        val responseLiveData : LiveData<List<Movie>?> = movieViewModel.getMovies()

        responseLiveData.observe(this, Observer {
            Log.i("MYTAG", it.toString())
            if(it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()

                binding.movieProgressBar.visibility = View.GONE
            }
            else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available as of now",Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun updateMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE

            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"Data not availablse, please try again later",Toast.LENGTH_SHORT).show()


            }
        })
    }
}