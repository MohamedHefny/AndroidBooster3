package com.example.booster3apps.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booster3apps.R
import com.example.booster3apps.models.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(private val moviesList: List<Movie>) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val movieViewLayout = layoutInflater.inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(movieViewLayout)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovieData(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.item_move_img

        fun bindMovieData(movie: Movie) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500/${movie.poster_path}").into(image)
        }
    }

}