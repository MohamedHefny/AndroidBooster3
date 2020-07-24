package com.example.booster3apps.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table")
data class Movie(
    @PrimaryKey
    val id: Int,
    val title: String,
    val overview: String,
    val vote_average: Float,
    val poster_path: String,
    val original_language: String
)