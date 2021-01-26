package com.example.bestofentertainment.presentation.di.core

import com.example.bestofentertainment.data.api.TMDBService
import com.example.bestofentertainment.data.db.ArtistDao
import com.example.bestofentertainment.data.db.MovieDao
import com.example.bestofentertainment.data.db.TvShowDao
import com.example.bestofentertainment.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.bestofentertainment.data.repository.artist.datasourceimpl.ArtistLocalDatasourceImpl
import com.example.bestofentertainment.data.repository.movie.datasource.MovieLocalDatasource
import com.example.bestofentertainment.data.repository.movie.datasourceimpl.MovieLocalDatasourceImpl
import com.example.bestofentertainment.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.example.bestofentertainment.data.repository.tvshow.datasourceimpl.TvShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun provideMovieLocalDatasource(movieDao: MovieDao): MovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDao)
    }


    @Singleton
    @Provides
    fun provideTvShowLocalDatasource(tvShowDao: TvShowDao): TvShowLocalDatasource {
        return TvShowLocalDatasourceImpl(tvShowDao)
    }


    @Singleton
    @Provides
    fun provideArtistLocalDatasource(artistDao: ArtistDao): ArtistLocalDatasource {
        return ArtistLocalDatasourceImpl(artistDao)
    }


}