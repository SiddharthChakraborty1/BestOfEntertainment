package com.example.bestofentertainment.data.repository.tvshow.datasourceimpl

import com.example.bestofentertainment.data.db.TvShowDao
import com.example.bestofentertainment.data.model.tvshow.TvShow
import com.example.bestofentertainment.data.repository.tvshow.datasource.TvShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDatasourceImpl(private val tvShowDao: TvShowDao):
    TvShowLocalDatasource {
    override suspend fun getTvShowsFromDb(): List<TvShow> {
        return tvShowDao.getAllTvShows()
    }

    override suspend fun saveTvShowsToDb(tvShows: List<TvShow>) {

        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShow(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}