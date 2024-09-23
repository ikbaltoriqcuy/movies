package com.tor.movies.repository.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
Created by ikbaltoriq on 22,September,2024
 **/

@Entity(tableName = "movie")
data class MovieVO (
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("year")
    val year: String,
    @ColumnInfo("imdbId")
    val imdbId: String,
    @ColumnInfo("type")
    val type: String,
    @ColumnInfo("poster")
    val poster: String
)