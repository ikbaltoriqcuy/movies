package com.tor.movies.repository.data.local.remote

import com.tor.movies.repository.data.local.service.MovieDao
import com.tor.movies.repository.data.online.model.Movie
import javax.inject.Inject

/**
Created by ikbaltoriq on 23,September,2024
 **/
class MovieLocalRepoImpls @Inject constructor(private val movieDao: MovieDao): MovieLocalRepo {

    override suspend fun insertMovies(movies: List<Movie>): Int {
        return movieDao.insertMovies(movies)
    }

    override suspend fun deleteMovie(): Int {
        return movieDao.deleteMovie()
    }

    override suspend fun getAllMovies(): List<Movie> {
        return movieDao.getAllMovies()
    }
}