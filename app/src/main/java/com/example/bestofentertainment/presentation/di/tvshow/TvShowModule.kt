package com.example.bestofentertainment.presentation.di.tvshow

import com.example.bestofentertainment.domain.usecase.GetTvShowUsecase
import com.example.bestofentertainment.domain.usecase.UpdateTvShowsUsecase
import com.example.bestofentertainment.presentation.tvshow.TvShowActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTvShowUsecase: GetTvShowUsecase, updateTvShowsUsecase: UpdateTvShowsUsecase): TvShowActivityViewModelFactory{
        return TvShowActivityViewModelFactory(getTvShowUsecase,updateTvShowsUsecase)
    }
}