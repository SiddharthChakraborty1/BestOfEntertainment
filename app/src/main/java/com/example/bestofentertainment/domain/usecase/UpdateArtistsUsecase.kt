package com.example.bestofentertainment.domain.usecase

import com.example.bestofentertainment.data.model.artist.Artist
import com.example.bestofentertainment.domain.repository.ArtistRepository

class UpdateArtistsUsecase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}