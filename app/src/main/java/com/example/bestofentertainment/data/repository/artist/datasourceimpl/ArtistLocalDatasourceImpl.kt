package com.example.bestofentertainment.data.repository.artist.datasourceimpl

import com.example.bestofentertainment.data.db.ArtistDao
import com.example.bestofentertainment.data.model.artist.Artist
import com.example.bestofentertainment.data.repository.artist.datasource.ArtistLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDatasourceImpl(private val artistDao: ArtistDao):
    ArtistLocalDatasource {
    override suspend fun getArtistsFromDb(): List<Artist>  = artistDao.getAllArtists()



    override suspend fun saveArtistsToDb(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAllArtistsFromDb() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}