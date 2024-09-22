package com.tor.movies.di

import android.content.Context
import androidx.room.Room
import com.tor.movies.domain.usecase.GetMoviesUseCase
import com.tor.movies.domain.usecase.MoviesLocalUseCase
import com.tor.movies.repository.data.local.service.MovieDao
import com.tor.movies.repository.data.local.model.MovieDatabase
import com.tor.movies.repository.data.local.remote.MovieLocalRepoImpls
import com.tor.movies.repository.data.online.remote.MoviesRepoImpl
import com.tor.movies.repository.data.online.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
Created by ikbaltoriq on 23,September,2024
 **/

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MovieDatabase =
        Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movieDatabase"
        ).build()

    @Singleton
    @Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao = database.movieDao()

    @Singleton
    @Provides
    fun providesMovieLocalRepoImpls(movieDao: MovieDao) = MovieLocalRepoImpls(movieDao)

    @Singleton
    @Provides
    fun providesMoviesLocalUseCase(repo: MovieLocalRepoImpls) = MoviesLocalUseCase(repo)
}