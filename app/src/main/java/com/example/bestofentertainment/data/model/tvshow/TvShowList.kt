package com.example.bestofentertainment.data.model.tvshow


import com.example.bestofentertainment.data.model.tvshow.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShows: List<TvShow>


)