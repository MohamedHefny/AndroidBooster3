package com.example.booster3apps.ui.main

import androidx.lifecycle.ViewModel
import com.example.booster3apps.repositories.MoviesRepository

class MainViewModel : ViewModel() {

    fun getMovies(callback: MoviesRepository.MoviesCallback){
        MoviesRepository.getMovies(callback)
    }

}