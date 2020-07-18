package com.example.booster3apps

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.booster3apps.models.Movie
import com.example.booster3apps.models.MovieResponse
import com.example.booster3apps.network.ApiService
import com.example.booster3apps.network.RetrofitClient
import com.example.booster3apps.repositories.MoviesRepository
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MoviesRepository.MoviesCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MoviesRepository.getMovies(this)

    }

    override fun onMoviesReady(movies: List<Movie>) {
        main_recycler.adapter = MoviesAdapter(movies)
    }

}