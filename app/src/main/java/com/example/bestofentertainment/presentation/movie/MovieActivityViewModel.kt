package com.example.bestofentertainment.presentation.movie

import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.bestofentertainment.domain.usecase.GetMoviesUsecase
import com.example.bestofentertainment.domain.usecase.UpdateMoviesUsecase

class MovieActivityViewModel(
    private val getMoviesUsecase: GetMoviesUsecase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUsecase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUsecase.execute()
        emit(movieList)
    }
}