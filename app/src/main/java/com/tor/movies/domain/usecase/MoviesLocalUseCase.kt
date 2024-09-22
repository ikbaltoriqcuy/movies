package com.tor.movies.domain.usecase

import com.tor.movies.repository.data.online.model.ResponseMovie
import com.tor.movies.repository.data.online.remote.MovieRepo
import com.tor.common.network.Result
import com.tor.movies.repository.data.local.remote.MovieLocalRepo
import com.tor.movies.repository.data.local.service.MovieDao
import com.tor.movies.repository.data.online.model.Movie
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
Created by ikbaltoriq on 28,August,2024
 **/
class MoviesLocalUseCase @Inject constructor(
    private val repo: MovieLocalRepo
) {

    suspend fun getMovies(): Flow<List<Movie>> = flow {
        emit(repo.getAllMovies())
    }

    suspend fun deleteMovies(): Flow<Int> = flow {
        emit(repo.deleteMovie())
    }

    suspend fun insertMovies(movies: List<Movie>): Flow<Int> = flow {
        emit(repo.insertMovies(movies))
    }
}