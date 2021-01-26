package com.example.bestofentertainment.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bestofentertainment.data.db.ArtistDao
import com.example.bestofentertainment.data.db.MovieDao
import com.example.bestofentertainment.data.db.TvShowDao
import com.example.bestofentertainment.data.model.artist.Artist
import com.example.bestofentertainment.data.model.movie.Movie
import com.example.bestofentertainment.data.model.tvshow.TvShow

@Database(entities = [Movie::class, Artist::class, TvShow::class],
    version = 1,
    exportSchema = false)
abstract class TMDBdatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    abstract fun tvShowDao(): TvShowDao

    abstract fun artistDao(): ArtistDao
}