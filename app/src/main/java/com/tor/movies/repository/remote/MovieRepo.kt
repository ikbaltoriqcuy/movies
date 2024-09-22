package com.tor.movies.repository.remote

import com.tor.movies.repository.model.ResponseMovie
import com.tor.common.network.Result


/**
Created by ikbaltoriq on 28,August,2024
 **/
interface MovieRepo {
    suspend fun getMoviesByTitle(title: String, page: Int): Result<ResponseMovie>
}