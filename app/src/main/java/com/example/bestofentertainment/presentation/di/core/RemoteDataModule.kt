package com.example.bestofentertainment.presentation.di.core

import com.example.bestofentertainment.data.api.TMDBService
import com.example.bestofentertainment.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.bestofentertainment.data.repository.artist.datasourceimpl.ArtistRemoteDatasourceImpl
import com.example.bestofentertainment.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.bestofentertainment.data.repository.movie.datasourceimpl.MovieRemoteDatasourceImpl
import com.example.bestofentertainment.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.bestofentertainment.data.repository.tvshow.datasourceimpl.TvShowRemoteDatasourceImpl
import dagger.MapKey
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDatasource(tmdbService: TMDBService): MovieRemoteDatasource{
        return MovieRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDatasource(tmdbService: TMDBService): ArtistRemoteDatasource{
        return ArtistRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDatasource(tmdbService: TMDBService): TvShowRemoteDatasource{
        return TvShowRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }
}