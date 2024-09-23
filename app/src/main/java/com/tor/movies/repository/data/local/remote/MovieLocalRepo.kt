package com.tor.movies.repository.data.local.remote

import com.tor.movies.repository.data.local.model.MovieVO
import com.tor.movies.repository.data.online.model.Movie

/**
Created by ikbaltoriq on 23,September,2024
 **/
interface MovieLocalRepo {
    suspend fun insertMovies(movies: List<MovieVO>): List<Long>

    suspend fun deleteMovie(): Int

    suspend fun getAllMovies(): List<MovieVO>
}