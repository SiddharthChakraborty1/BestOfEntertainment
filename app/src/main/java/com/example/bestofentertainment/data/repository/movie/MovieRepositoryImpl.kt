package com.example.bestofentertainment.data.repository.movie

import android.util.Log
import com.example.bestofentertainment.data.model.movie.Movie
import com.example.bestofentertainment.data.repository.movie.datasource.MovieCacheDatasource
import com.example.bestofentertainment.data.repository.movie.datasource.MovieLocalDatasource
import com.example.bestofentertainment.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.bestofentertainment.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieRemoteDatasource: MovieRemoteDatasource,
                          private val movieLocalDatasource: MovieLocalDatasource,
                          private val movieCacheDatasource: MovieCacheDatasource
): MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDatasource.clearAll()
        movieCacheDatasource.clearMoviesFromCache()
        movieLocalDatasource.saveMoviesToDb(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie>{
        lateinit var movieList: List<Movie>

        try{
            val response = movieRemoteDatasource.getMoviesFromApi()
            val body = response.body()
            if(body!= null){

                movieList = body.movies
            }

        }
        catch (e: Exception)
        {
            Log.i("MYTAG",e.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDb():List<Movie>{
        lateinit var movieList: List<Movie>

        try{
            movieList = movieLocalDatasource.getMoviesFromDb()

        }
        catch (e: Exception)
        {
            Log.i("MYTAG",e.message.toString())
        }
        if (movieList.size > 0){
            return movieList

        }
        else{
            movieList = getMoviesFromApi()
            movieLocalDatasource.saveMoviesToDb(movieList)
            return movieList
        }


    }

    suspend fun getMoviesFromCache(): List<Movie>{

        lateinit var movieList: List<Movie>

        try{
            movieList = movieCacheDatasource.getMoviesFromCache()

        }


        catch (e: Exception)
        {
            Log.i("MYTAG",e.message.toString())
        }
        if (movieList.size > 0){
            return movieList


        }
        else{
            movieList = getMoviesFromDb()
            movieCacheDatasource.saveMoviesToCache(movieList)
            return movieList

        }




    }

}