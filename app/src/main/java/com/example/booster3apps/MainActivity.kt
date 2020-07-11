package com.example.booster3apps

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.booster3apps.models.Movie
import com.example.booster3apps.models.MovieResponse
import com.example.booster3apps.network.ApiService
import com.example.booster3apps.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val tag: String = MainActivity::class.java.simpleName

    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RetrofitClient.getClient().create(ApiService::class.java)

        apiService.getMovies("d78d306988042530d99e166c3cb00017")
            .enqueue(object : Callback<MovieResponse> {

                override fun onResponse(
                    call: Call<MovieResponse>, response: Response<MovieResponse>
                ) {

                    if (response.isSuccessful) {
                        val moviesList: List<Movie> = response.body()?.results ?: listOf()
                        main_recycler.adapter = MoviesAdapter(moviesList)
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.e(tag, t.message.toString())
                }

            })
    }
}