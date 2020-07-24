package com.example.booster3apps.models

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val vote_average: Float,
    val poster_path: String,
    val original_language: String
)