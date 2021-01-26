package com.example.bestofentertainment.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.bestofentertainment.domain.usecase.GetTvShowUsecase
import com.example.bestofentertainment.domain.usecase.UpdateTvShowsUsecase

class TvShowActivityViewModel(private val getTvShowUsecase: GetTvShowUsecase,
private val updateTvShowsUsecase: UpdateTvShowsUsecase): ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowUsecase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUsecase.execute()
        emit(tvShowList)
    }
}