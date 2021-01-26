package com.example.bestofentertainment.data.repository.movie.datasourceimpl

import com.example.bestofentertainment.data.db.MovieDao
import com.example.bestofentertainment.data.model.movie.Movie
import com.example.bestofentertainment.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(private val movieDao: MovieDao):
    MovieLocalDatasource {

    override suspend fun getMoviesFromDb(): List<Movie> = movieDao.getAllMovies()


    override suspend fun saveMoviesToDb(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}