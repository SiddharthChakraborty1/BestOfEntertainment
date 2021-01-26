package com.example.bestofentertainment.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bestofentertainment.data.model.tvshow.TvShow
@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShows: List<TvShow>)

    @Query("SELECT * FROM popular_tv_shows_table")
    suspend fun getAllTvShows(): List<TvShow>

    @Query("DELETE FROM popular_tv_shows_table")
    suspend fun deleteAllTvShows()
}