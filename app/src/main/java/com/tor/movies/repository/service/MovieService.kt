package com.tor.movies.repository.service

import com.tor.common.network.ConfigNetwork
import com.tor.movies.repository.model.ResponseMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
Created by ikbaltoriq on 22,September,2024
 **/
interface MovieService {
    @GET("?apikey=${ConfigNetwork.API_KEY}&type=movie")
    suspend fun getMoviesByTitle(
        @Query("s") searchTerm: String,
        @Query("page") page: Int
    ): Response<ResponseMovie>
}