package com.example.bestofentertainment.presentation.di


import com.example.bestofentertainment.presentation.di.artist.ArtistSubComponent
import com.example.bestofentertainment.presentation.di.movie.MovieSubComponent
import com.example.bestofentertainment.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent

}