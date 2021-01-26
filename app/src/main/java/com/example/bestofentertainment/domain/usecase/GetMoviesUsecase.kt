package com.example.bestofentertainment.domain.usecase

import com.example.bestofentertainment.data.model.movie.Movie
import com.example.bestofentertainment.domain.repository.MovieRepository

class GetMoviesUsecase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()


}