package com.example.bestofentertainment.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.manager.ConnectivityMonitorFactory
import com.example.bestofentertainment.R
import com.example.bestofentertainment.databinding.ActivityTvShowBinding
import com.example.bestofentertainment.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowActivityViewModelFactory
   private lateinit var viewModel: TvShowActivityViewModel
    private lateinit var adapter: TvShowAdapter
    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this,factory).get(TvShowActivityViewModel::class.java)

        initRecyclerView()

        binding.tvShowFloatingActionButton.setOnClickListener{

            updateTShows()
        }


    }

    private fun initRecyclerView(){
        binding.progressBarTvShow.visibility = View.VISIBLE
        binding.recyclerViewTvShow.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.recyclerViewTvShow.adapter = adapter
        displayTvShows()

    }

    private fun displayTvShows(){
        val responseLiveData = viewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarTvShow.visibility = View.GONE
            }else{
                Toast.makeText(applicationContext,"No data available as of now",Toast.LENGTH_SHORT).show()
                binding.progressBarTvShow.visibility = View.GONE
            }
        })
    }

    private fun updateTShows(){
        binding.progressBarTvShow.visibility = View.VISIBLE

        val response = viewModel.updateTvShows()

        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarTvShow.visibility = View.GONE
            }
            else{
                Toast.makeText(applicationContext,"Data not availablse, please try again later",Toast.LENGTH_SHORT).show()
                binding.progressBarTvShow.visibility = View.GONE
            }
        })
    }

}