package com.example.bestofentertainment.data.repository.tvshow

import android.util.Log
import com.example.bestofentertainment.data.model.tvshow.TvShow
import com.example.bestofentertainment.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.example.bestofentertainment.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.example.bestofentertainment.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.bestofentertainment.domain.repository.TvShowRepository

class TvShowRepositoryImpl(private val tvShowRemoteDatasource: TvShowRemoteDatasource,
private val tvShowCacheDatasource: TvShowCacheDatasource,
private val tvShowLocalDatasource: TvShowLocalDatasource): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newTvShowList = getTvshowsFromApi()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowsToDb(newTvShowList)
        tvShowCacheDatasource.saveTvShowsToCache(newTvShowList)
        return newTvShowList
    }

    suspend fun getTvshowsFromApi(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try {

            val response = tvShowRemoteDatasource.getTvShowsFromApi()
            val body = response.body()
            if(body!=null){
                tvShowList = body.tvShows
            }

        }catch (e: Exception){
            Log.i("MYTAG",e.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowsFromDb(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try{

            tvShowList = tvShowLocalDatasource.getTvShowsFromDb()

        }
        catch (e: Exception){
            Log.i("MYTAG",e.message.toString())
        }
        if(tvShowList.size > 0){
            return tvShowList
        }
        else
        {
            tvShowList = getTvshowsFromApi()
            tvShowLocalDatasource.saveTvShowsToDb(tvShowList)
        }

        return tvShowList

    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvSHowList : List<TvShow>

        try{
            tvSHowList = tvShowCacheDatasource.getTvShowsFromCache()
        }
        catch (exception: Exception)
        {
            Log.i("MYTAG",exception.message.toString())
        }
        if(tvSHowList.size>0){
            return tvSHowList
        }
        else
        {
            tvSHowList = getTvShowsFromDb()
            tvShowCacheDatasource.saveTvShowsToCache(tvSHowList)
            return tvSHowList
        }
    }
}