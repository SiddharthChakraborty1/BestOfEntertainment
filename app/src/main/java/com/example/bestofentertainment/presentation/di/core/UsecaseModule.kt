package com.example.bestofentertainment.presentation.di.core

import com.example.bestofentertainment.domain.repository.ArtistRepository
import com.example.bestofentertainment.domain.repository.MovieRepository
import com.example.bestofentertainment.domain.repository.TvShowRepository
import com.example.bestofentertainment.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UsecaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUsecase(movieRepository: MovieRepository):GetMoviesUsecase{
        return GetMoviesUsecase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUsecase(movieRepository: MovieRepository): UpdateMoviesUsecase{
        return UpdateMoviesUsecase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowUsecase(tvShowRepository: TvShowRepository):GetTvShowUsecase{
        return GetTvShowUsecase(tvShowRepository)

    }
    @Singleton
    @Provides
    fun provideUpdateTvShowUsecase(tvShowRepository: TvShowRepository):UpdateTvShowsUsecase{
        return UpdateTvShowsUsecase(tvShowRepository)

    }

    @Singleton
    @Provides
    fun provideGetArtistUsecase(artistRepository: ArtistRepository):GetArtistsUsecase{
        return GetArtistsUsecase(artistRepository)

    }

    @Singleton
    @Provides
    fun provideUpdateArtistUsecase(artistRepository: ArtistRepository):UpdateArtistsUsecase{
        return UpdateArtistsUsecase(artistRepository)

    }


}