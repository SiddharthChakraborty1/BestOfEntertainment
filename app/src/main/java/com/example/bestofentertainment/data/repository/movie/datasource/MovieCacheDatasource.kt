package com.example.bestofentertainment.data.repository.movie.datasource

import com.example.bestofentertainment.data.model.movie.Movie

interface MovieCacheDatasource {

    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)

    suspend fun clearMoviesFromCache()
}