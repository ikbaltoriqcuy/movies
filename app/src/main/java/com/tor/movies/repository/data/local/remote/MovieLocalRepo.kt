package com.tor.movies.repository.data.local.remote

import androidx.room.Query
import com.tor.movies.repository.data.online.model.Movie

/**
Created by ikbaltoriq on 23,September,2024
 **/
interface MovieLocalRepo {
    suspend fun insertMovies(movies: List<Movie>): Int

    suspend fun deleteMovie(): Int

    suspend fun getAllMovies(): List<Movie>
}