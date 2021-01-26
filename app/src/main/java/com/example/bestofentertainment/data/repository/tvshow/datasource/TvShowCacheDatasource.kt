package com.example.bestofentertainment.data.repository.tvshow.datasource

import com.example.bestofentertainment.data.model.movie.Movie
import com.example.bestofentertainment.data.model.tvshow.TvShow

interface TvShowCacheDatasource {

    suspend fun getTvShowsFromCache(): List<TvShow>

    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)

}