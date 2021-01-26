package com.example.bestofentertainment.domain.repository

import com.example.bestofentertainment.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?
}