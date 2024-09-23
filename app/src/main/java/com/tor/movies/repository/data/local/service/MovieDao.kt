package com.tor.movies.repository.data.local.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tor.movies.repository.data.local.model.MovieVO
import com.tor.movies.repository.data.online.model.Movie

/**
Created by ikbaltoriq on 23,September,2024
 **/

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieVO>): List<Long>

    @Query("DELETE FROM movie")
    suspend fun deleteMovie(): Int

    @Query("SELECT * FROM movie")
    suspend fun getAllMovies(): List<MovieVO>
}