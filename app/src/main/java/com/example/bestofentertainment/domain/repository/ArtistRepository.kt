package com.example.bestofentertainment.domain.repository

import com.example.bestofentertainment.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}