package com.example.bestofentertainment.domain.usecase

import com.example.bestofentertainment.data.model.tvshow.TvShow
import com.example.bestofentertainment.domain.repository.TvShowRepository

class GetTvShowUsecase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}