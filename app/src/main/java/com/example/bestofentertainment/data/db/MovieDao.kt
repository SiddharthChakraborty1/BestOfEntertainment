package com.example.bestofentertainment.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bestofentertainment.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM popular_movies_table")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_movies_table")
    suspend fun getAllMovies(): List<Movie>
}
