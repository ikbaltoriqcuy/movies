package com.tor.movies.repository.data.online.model

import com.google.gson.annotations.SerializedName

/**
Created by ikbaltoriq on 22,September,2024
 **/
data class Movie (
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("imdbID")
    val imdbId: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Poster")
    val poster: String
)