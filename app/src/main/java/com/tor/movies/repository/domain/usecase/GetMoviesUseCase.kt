package com.tor.movies.repository.domain.usecase

import com.tor.movies.repository.model.ResponseMovie
import com.tor.movies.repository.remote.MovieRepo
import com.tor.common.network.Result
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
Created by ikbaltoriq on 28,August,2024
 **/
class GetMoviesUseCase @Inject constructor(
    private val repo: MovieRepo
) {

    suspend fun invoke(title: String, page: Int): Flow<Result<ResponseMovie>> = flow {
        emit(repo.getMoviesByTitle(title, page))
    }
}