package com.example.bestofentertainment.presentation.di.core

import com.example.bestofentertainment.data.model.artist.Artist
import com.example.bestofentertainment.data.model.tvshow.TvShow
import com.example.bestofentertainment.presentation.di.artist.ArtistSubComponent
import com.example.bestofentertainment.presentation.di.movie.MovieSubComponent
import com.example.bestofentertainment.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
NetModule::class,
CacheDataModule::class,
DatabaseModule::class,
LocalDataModule::class,
RemoteDataModule::class,
RepositoryModule::class,
UsecaseModule::class])
interface AppComponent {


    fun movieSubComponent(): MovieSubComponent.Factory


    fun tvShowSubComponent(): TvShowSubComponent.Factory

    fun artistSubComponent(): ArtistSubComponent.Factory
}