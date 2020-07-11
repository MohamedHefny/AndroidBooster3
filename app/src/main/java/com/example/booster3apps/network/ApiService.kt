package com.example.booster3apps.network

import com.example.booster3apps.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/movie/popular")
    fun getMovies(): Call<MovieResponse>

}