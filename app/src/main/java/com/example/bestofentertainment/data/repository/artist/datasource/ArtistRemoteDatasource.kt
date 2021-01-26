package com.example.bestofentertainment.data.repository.artist.datasource

import com.example.bestofentertainment.data.model.artist.Artist
import com.example.bestofentertainment.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {

    suspend fun getArtistsFromApi(): Response<ArtistList>
}