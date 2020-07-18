package com.example.booster3apps.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.booster3apps.models.Movie
import com.example.booster3apps.repositories.MoviesRepository

class MainViewModel : ViewModel() {

    fun getMovies(): LiveData<List<Movie>> {
        return MoviesRepository.getMovies()
    }

}