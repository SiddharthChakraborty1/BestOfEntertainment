package com.example.bestofentertainment.data.repository.artist

import android.util.Log
import com.example.bestofentertainment.data.model.artist.Artist
import com.example.bestofentertainment.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.bestofentertainment.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.bestofentertainment.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.bestofentertainment.domain.repository.ArtistRepository

class ArtistRepositoryImpl(private val artistRemoteDatasource: ArtistRemoteDatasource,
private val artistLocalDatasource: ArtistLocalDatasource,
private val artistCacheDatasource: ArtistCacheDatasource): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newArtistList = getArtistsFromApi()
        artistLocalDatasource.clearAllArtistsFromDb()
        artistLocalDatasource.saveArtistsToDb(newArtistList)
        artistCacheDatasource.saveArtistsToCache(newArtistList)
        return newArtistList
    }

    suspend fun getArtistsFromApi(): List<Artist>{
        lateinit var artistList: List<Artist>

        try {

            val response = artistRemoteDatasource.getArtistsFromApi()
            val body = response.body()
            if(body!=null){
                artistList  = body.artists
            }

        }
        catch (exception: Exception){
            Log.i("MYTAG",exception.message.toString())
        }
        return artistList

    }

    suspend fun getArtistsFromDb(): List<Artist>{
        lateinit var artistList: List<Artist>

        try{

            artistList = artistLocalDatasource.getArtistsFromDb()

        }
        catch (exception: Exception){
            Log.i("MYTAG",exception.message.toString())
        }

        if(artistList.size >0){
            return artistList
        }
        else
        {
            artistList = getArtistsFromApi()
            artistLocalDatasource.saveArtistsToDb(artistList)
            return artistList
        }
    }

    suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>

        try{

            artistList = artistCacheDatasource.getArtistsFromCache()

        }
        catch (exception: Exception){
            Log.i("MYTAG",exception.message.toString())
        }

        if(artistList.size >0){
            return artistList
        }
        else
        {
            artistList = getArtistsFromDb()
            artistCacheDatasource.saveArtistsToCache(artistList)
            return artistList
        }
    }
}