package com.example.bestofentertainment.domain.usecase

import com.example.bestofentertainment.data.model.artist.Artist
import com.example.bestofentertainment.domain.repository.ArtistRepository

class GetArtistsUsecase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}