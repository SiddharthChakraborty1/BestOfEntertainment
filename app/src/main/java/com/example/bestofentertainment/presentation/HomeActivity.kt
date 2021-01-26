package com.example.bestofentertainment.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bestofentertainment.R
import com.example.bestofentertainment.data.model.tvshow.TvShow
import com.example.bestofentertainment.databinding.ActivityHomeBinding
import com.example.bestofentertainment.presentation.artist.ArtistActivity
import com.example.bestofentertainment.presentation.movie.MovieActivity
import com.example.bestofentertainment.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.btnMovies.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.btnTvShows.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }


    }
}