package com.example.bestofentertainment.data.repository.movie.datasource

import com.example.bestofentertainment.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {

    suspend fun getMoviesFromApi(): Response<MovieList>

}