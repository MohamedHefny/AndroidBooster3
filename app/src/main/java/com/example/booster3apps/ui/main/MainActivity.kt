package com.example.booster3apps.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.booster3apps.R
import com.example.booster3apps.models.Movie
import com.example.booster3apps.repositories.MoviesRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.getMovies(object : MoviesRepository.MoviesCallback {
            override fun onMoviesReady(movies: List<Movie>) {
                    main_recycler.adapter = MoviesAdapter(movies)
            }
        })
    }
}