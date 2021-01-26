package com.example.bestofentertainment.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bestofentertainment.domain.usecase.GetMoviesUsecase
import com.example.bestofentertainment.domain.usecase.UpdateMoviesUsecase

class MovieActivityViewModelFactory(private val getMoviesUsecase: GetMoviesUsecase,
private val updateMoviesUsecase: UpdateMoviesUsecase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{

        return MovieActivityViewModel(getMoviesUsecase, updateMoviesUsecase) as T

    }
}