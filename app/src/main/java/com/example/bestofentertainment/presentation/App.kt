package com.example.bestofentertainment.presentation

import android.app.Application
import com.example.bestofentertainment.BuildConfig

import com.example.bestofentertainment.presentation.di.Injector
import com.example.bestofentertainment.presentation.di.artist.ArtistSubComponent
import com.example.bestofentertainment.presentation.di.core.*

import com.example.bestofentertainment.presentation.di.movie.MovieSubComponent
import com.example.bestofentertainment.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()



    }

    override fun createMovieComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
       return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
       return appComponent.artistSubComponent().create()
    }
}