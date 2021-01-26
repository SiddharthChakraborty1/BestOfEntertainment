package com.example.bestofentertainment.data.repository.tvshow.datasourceimpl

import com.example.bestofentertainment.data.model.tvshow.TvShow
import com.example.bestofentertainment.data.repository.tvshow.datasource.TvShowCacheDatasource


class TvShowCacheDatasourceImpl:
    TvShowCacheDatasource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)

    }

}