package com.tor.movies.repository.data.online.remote

import com.tor.movies.repository.data.online.model.ResponseMovie
import com.tor.movies.repository.data.online.service.MovieService
import com.tor.common.network.Result

/**
Created by ikbaltoriq on 28,August,2024
 **/
class MoviesRepoImpl(private var movieService: MovieService): MovieRepo {
    override suspend fun getMoviesByTitle(title: String, page: Int): Result<ResponseMovie> {
        return try {
            val response = movieService.getMoviesByTitle(title, page)
            if (response.isSuccessful) {
                Result.Success(response.body()!!)
            } else {
                Result.Error(Exception("Failed to load posts"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}