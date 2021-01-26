package com.example.bestofentertainment.data.repository.tvshow.datasourceimpl

import com.example.bestofentertainment.data.api.TMDBService
import com.example.bestofentertainment.data.model.movie.MovieList
import com.example.bestofentertainment.data.model.tvshow.TvShowList
import com.example.bestofentertainment.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String):
    TvShowRemoteDatasource {

    override suspend fun getTvShowsFromApi(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)


}