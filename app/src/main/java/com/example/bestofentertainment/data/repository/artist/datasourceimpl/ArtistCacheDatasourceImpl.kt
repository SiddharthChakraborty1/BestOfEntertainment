package com.example.bestofentertainment.data.repository.artist.datasourceimpl

import com.example.bestofentertainment.data.model.artist.Artist
import com.example.bestofentertainment.data.repository.artist.datasource.ArtistCacheDatasource

class ArtistCacheDatasourceImpl: ArtistCacheDatasource {

    private var artisList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artisList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artisList.clear()
        artisList = ArrayList(artists)
    }

}