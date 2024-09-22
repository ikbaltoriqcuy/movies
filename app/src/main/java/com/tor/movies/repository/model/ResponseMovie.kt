package com.tor.movies.repository.model

import com.google.gson.annotations.SerializedName

/**
Created by ikbaltoriq on 22,September,2024
 **/
data class ResponseMovie (
    @SerializedName("Search")
    val search: List<Movie>,
    @SerializedName("totalResults")
    val totalResult: Int,
    @SerializedName("Response")
    val response: String
)