package com.example.bestofentertainment.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.bestofentertainment.domain.usecase.GetArtistsUsecase
import com.example.bestofentertainment.domain.usecase.UpdateArtistsUsecase

class ArtistActivityViewModel(private val getArtistsUsecase: GetArtistsUsecase,
                              private val updateArtistsUsecase: UpdateArtistsUsecase): ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistsUsecase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUsecase.execute()
        emit(artistList)
    }
}