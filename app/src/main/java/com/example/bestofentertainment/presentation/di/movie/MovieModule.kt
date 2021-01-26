package com.example.bestofentertainment.presentation.di.movie

import com.example.bestofentertainment.domain.usecase.GetMoviesUsecase
import com.example.bestofentertainment.domain.usecase.UpdateMoviesUsecase
import com.example.bestofentertainment.presentation.movie.MovieActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {


    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMoviesUsecase: GetMoviesUsecase,updateMoviesUsecase: UpdateMoviesUsecase): MovieActivityViewModelFactory{
        return MovieActivityViewModelFactory(getMoviesUsecase,updateMoviesUsecase)
    }
}