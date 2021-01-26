package com.example.bestofentertainment.data.repository.artist.datasource

import com.example.bestofentertainment.data.model.artist.Artist

interface ArtistLocalDatasource {

    suspend fun getArtistsFromDb(): List<Artist>

    suspend fun saveArtistsToDb(artists: List<Artist>)

    suspend fun clearAllArtistsFromDb()
}