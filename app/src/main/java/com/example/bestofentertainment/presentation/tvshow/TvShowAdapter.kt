package com.example.bestofentertainment.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bestofentertainment.R
import com.example.bestofentertainment.data.model.tvshow.TvShow
import com.example.bestofentertainment.databinding.ActivityTvShowBinding
import com.example.bestofentertainment.databinding.ListItemTvShowBinding

class TvShowAdapter: RecyclerView.Adapter<MyViewholder>() {

    private val tvShowList = ArrayList<TvShow>()

    fun setList(tvShows: List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemTvShowBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.list_item_tv_show,
            parent,
            false
        )

        return MyViewholder(binding)


    }

    override fun getItemCount():Int = tvShowList.size

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        holder.bind(tvShowList[position])
    }
}

class MyViewholder(private val binding: ListItemTvShowBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name
        val posterUrl = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
        binding.tvFirstAirDate.text = "First aired on: "+tvShow.firstAirDate
        binding.descriptionTextView.text = tvShow.overview
    }

}