package com.example.bestofentertainment.domain.usecase

import com.example.bestofentertainment.data.model.movie.Movie
import com.example.bestofentertainment.domain.repository.MovieRepository

class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}