package com.example.bestofentertainment.data.repository.movie.datasourceimpl

import com.example.bestofentertainment.data.model.movie.Movie
import com.example.bestofentertainment.data.repository.movie.datasource.MovieCacheDatasource

class MovieCacheDatasourceImpl:
    MovieCacheDatasource {

    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

    override suspend fun clearMoviesFromCache() {
        movieList.clear()
    }
}