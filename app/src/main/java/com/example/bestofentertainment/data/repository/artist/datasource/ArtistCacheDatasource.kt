package com.example.bestofentertainment.data.repository.artist.datasource

import com.example.bestofentertainment.data.model.artist.Artist

interface ArtistCacheDatasource {

    suspend fun getArtistsFromCache(): List<Artist>

    suspend fun saveArtistsToCache(artists: List<Artist>)


}