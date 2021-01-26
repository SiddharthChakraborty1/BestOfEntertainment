package com.example.bestofentertainment.presentation.di.core

import com.example.bestofentertainment.data.repository.artist.ArtistRepositoryImpl
import com.example.bestofentertainment.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.bestofentertainment.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.bestofentertainment.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.bestofentertainment.data.repository.movie.MovieRepositoryImpl
import com.example.bestofentertainment.data.repository.movie.datasource.MovieCacheDatasource
import com.example.bestofentertainment.data.repository.movie.datasource.MovieLocalDatasource
import com.example.bestofentertainment.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.bestofentertainment.data.repository.tvshow.TvShowRepositoryImpl
import com.example.bestofentertainment.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.example.bestofentertainment.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.example.bestofentertainment.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.bestofentertainment.domain.repository.ArtistRepository
import com.example.bestofentertainment.domain.repository.MovieRepository
import com.example.bestofentertainment.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDatasource,
            movieCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource,
        tvShowCacheDatasource: TvShowCacheDatasource
    ): TvShowRepository{
        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowCacheDatasource,
            tvShowLocalDatasource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDatasource: ArtistCacheDatasource
    ): ArtistRepository{
        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDatasource,
            artistCacheDatasource
        )
    }
}