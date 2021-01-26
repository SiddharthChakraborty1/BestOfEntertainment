package com.example.bestofentertainment.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bestofentertainment.domain.usecase.GetTvShowUsecase
import com.example.bestofentertainment.domain.usecase.UpdateTvShowsUsecase

class TvShowActivityViewModelFactory(private val getTvShowUsecase: GetTvShowUsecase,
private val updateTvShowsUsecase: UpdateTvShowsUsecase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowActivityViewModel(getTvShowUsecase,updateTvShowsUsecase) as T
    }
}