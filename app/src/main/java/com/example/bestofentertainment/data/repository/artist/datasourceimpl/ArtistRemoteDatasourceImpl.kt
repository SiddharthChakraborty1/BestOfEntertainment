package com.example.bestofentertainment.data.repository.artist.datasourceimpl

import com.example.bestofentertainment.data.api.TMDBService
import com.example.bestofentertainment.data.model.artist.ArtistList
import com.example.bestofentertainment.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String):
    ArtistRemoteDatasource {

    override suspend fun getArtistsFromApi(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}