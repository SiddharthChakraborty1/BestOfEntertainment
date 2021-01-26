package com.example.bestofentertainment.data.repository.tvshow.datasource

import com.example.bestofentertainment.data.model.movie.MovieList
import com.example.bestofentertainment.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {

    suspend fun getTvShowsFromApi(): Response<TvShowList>
}