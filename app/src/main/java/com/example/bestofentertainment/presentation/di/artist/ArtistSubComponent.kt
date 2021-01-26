package com.example.bestofentertainment.presentation.di.artist

import com.example.bestofentertainment.presentation.artist.ArtistActivity
import dagger.Subcomponent
import javax.inject.Inject

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ArtistSubComponent
    }
}