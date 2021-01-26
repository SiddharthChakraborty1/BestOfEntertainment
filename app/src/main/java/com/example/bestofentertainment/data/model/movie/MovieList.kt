package com.example.bestofentertainment.data.model.movie


import com.example.bestofentertainment.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>

)