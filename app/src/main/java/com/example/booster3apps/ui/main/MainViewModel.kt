package com.example.booster3apps.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.booster3apps.models.Movie
import com.example.booster3apps.repositories.MoviesRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    init {
        MoviesRepository.createDatabase(application)
    }

    fun getMovies(): LiveData<List<Movie>> {
        return MoviesRepository.getMovies()
    }

}