package com.example.bestofentertainment.presentation.di.core

import android.content.Context
import com.example.bestofentertainment.data.model.tvshow.TvShow
import com.example.bestofentertainment.presentation.di.artist.ArtistSubComponent
import com.example.bestofentertainment.presentation.di.movie.MovieSubComponent
import com.example.bestofentertainment.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [ArtistSubComponent::class, TvShowSubComponent::class,MovieSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }


}