package com.example.bestofentertainment.presentation.di.core

import com.example.bestofentertainment.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.bestofentertainment.data.repository.artist.datasourceimpl.ArtistCacheDatasourceImpl
import com.example.bestofentertainment.data.repository.movie.datasource.MovieCacheDatasource
import com.example.bestofentertainment.data.repository.movie.datasourceimpl.MovieCacheDatasourceImpl
import com.example.bestofentertainment.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.example.bestofentertainment.data.repository.tvshow.datasourceimpl.TvShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDatasource(): MovieCacheDatasource{
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDatasource(): TvShowCacheDatasource {
        return TvShowCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDatasource(): ArtistCacheDatasource{
        return ArtistCacheDatasourceImpl()
    }
}