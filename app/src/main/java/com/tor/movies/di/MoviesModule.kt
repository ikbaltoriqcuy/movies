package com.tor.movies.di

/**
Created by ikbaltoriq on 22,September,2024
 **/

import com.tor.movies.repository.domain.usecase.GetMoviesUseCase
import com.tor.movies.repository.remote.MoviesRepoImpl
import com.tor.movies.repository.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

/**
Created by ikbaltoriq on 28,August,2024
 **/

@Module
@InstallIn(SingletonComponent::class)
object PeopleListModule {

    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService = retrofit.create(MovieService::class.java)

    @Singleton
    @Provides
    fun providesMovieRepository(movieService: MovieService) = MoviesRepoImpl(movieService)

    @Singleton
    @Provides
    fun providesGetMoviesUseCase(repo: MoviesRepoImpl) = GetMoviesUseCase(repo)

}