package com.example.bestofentertainment.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bestofentertainment.R
import com.example.bestofentertainment.data.model.movie.Movie

import com.example.bestofentertainment.databinding.ListItemMovieBinding

class MovieAdapter(): RecyclerView.Adapter<MyViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemMovieBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item_movie,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = movieList.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }
}

class MyViewHolder(val binding: ListItemMovieBinding):
    RecyclerView.ViewHolder(binding.root){

    fun bind(movie: Movie){
        binding.titleTextView.text = movie.title
        binding.descriptionTextView.text = movie.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500"+movie.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)

    }
}