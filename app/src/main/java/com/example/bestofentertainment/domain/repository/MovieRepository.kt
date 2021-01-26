package com.example.bestofentertainment.domain.repository

import com.example.bestofentertainment.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}