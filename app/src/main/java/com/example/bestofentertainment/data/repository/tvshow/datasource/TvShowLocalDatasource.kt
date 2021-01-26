package com.example.bestofentertainment.data.repository.tvshow.datasource


import com.example.bestofentertainment.data.model.tvshow.TvShow

interface TvShowLocalDatasource {

    suspend fun getTvShowsFromDb(): List<TvShow>

    suspend fun saveTvShowsToDb(tvShows: List<TvShow>)

    suspend fun clearAll()
}