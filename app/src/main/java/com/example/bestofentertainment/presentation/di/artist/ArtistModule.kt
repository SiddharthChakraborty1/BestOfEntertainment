package com.example.bestofentertainment.presentation.di.artist

import com.example.bestofentertainment.domain.usecase.GetArtistsUsecase
import com.example.bestofentertainment.domain.usecase.UpdateArtistsUsecase
import com.example.bestofentertainment.presentation.artist.ArtistActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(getArtistsUsecase: GetArtistsUsecase,
                                      updateArtistsUsecase: UpdateArtistsUsecase): ArtistActivityViewModelFactory{
        return ArtistActivityViewModelFactory(getArtistsUsecase,updateArtistsUsecase)

    }
}