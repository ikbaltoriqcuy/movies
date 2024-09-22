package com.tor.movies.repository.data.local.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tor.movies.repository.data.local.service.MovieDao
import com.tor.movies.repository.data.online.model.Movie

/**
Created by ikbaltoriq on 23,September,2024
 **/

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}