package com.example.bestofentertainment.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bestofentertainment.domain.usecase.GetArtistsUsecase
import com.example.bestofentertainment.domain.usecase.UpdateArtistsUsecase

class ArtistActivityViewModelFactory(private val getArtistsUsecase: GetArtistsUsecase,
private val updateArtistsUsecase: UpdateArtistsUsecase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistActivityViewModel(getArtistsUsecase, updateArtistsUsecase) as T
    }
}