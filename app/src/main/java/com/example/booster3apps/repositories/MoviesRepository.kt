package com.example.booster3apps.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.booster3apps.models.Movie
import com.example.booster3apps.models.MovieResponse
import com.example.booster3apps.network.ApiService
import com.example.booster3apps.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MoviesRepository {

    private val tag: String = MoviesRepository::class.java.simpleName

    private val apiService = RetrofitClient.getClient().create(ApiService::class.java)

    private const val apiKey = "d78d306988042530d99e166c3cb00017"

    private val moviesList: MutableList<Movie> = mutableListOf()

    fun getMovies(): LiveData<List<Movie>> {
        val moviesListLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

        if (moviesList.size > 0) {
            moviesListLiveData.postValue(moviesList)
            return moviesListLiveData
        }

        apiService.getMovies(apiKey).enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                if (response.isSuccessful) {
                    val remoteMoviesList: List<Movie> = response.body()?.results ?: listOf()
                    moviesList.addAll(remoteMoviesList)
                    moviesListLiveData.postValue(moviesList)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(tag, t.message.toString())
            }

        })

        return moviesListLiveData
    }
}