package com.example.bestofentertainment.data.repository.movie.datasource

import com.example.bestofentertainment.data.model.movie.Movie

interface MovieLocalDatasource {

    suspend fun getMoviesFromDb(): List<Movie>

    suspend fun saveMoviesToDb(movies: List<Movie>)

    suspend fun clearAll()
}