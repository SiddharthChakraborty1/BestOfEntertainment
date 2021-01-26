package com.example.bestofentertainment.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.bestofentertainment.data.db.ArtistDao
import com.example.bestofentertainment.data.db.MovieDao
import com.example.bestofentertainment.data.db.TMDBdatabase
import com.example.bestofentertainment.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMoveDatabase(context: Context):  TMDBdatabase{
        return Room.databaseBuilder(context,
            TMDBdatabase::class.java,
            "tmdbClient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(database: TMDBdatabase): MovieDao{
        return database.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(database: TMDBdatabase): TvShowDao{
        return database.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(database: TMDBdatabase): ArtistDao{
        return database.artistDao()
    }
}