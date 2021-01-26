package com.example.bestofentertainment.data.repository.movie.datasourceimpl

import com.example.bestofentertainment.data.api.TMDBService
import com.example.bestofentertainment.data.model.movie.MovieList
import com.example.bestofentertainment.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String):
    MovieRemoteDatasource {


    override suspend fun getMoviesFromApi(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}