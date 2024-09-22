package com.tor.movies.ui.screen.movies

import com.tor.common.base.BaseViewModel
import com.tor.movies.repository.domain.usecase.GetMoviesUseCase
import com.tor.movies.repository.model.Movie
import com.tor.common.network.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
Created by ikbaltoriq on 22,September,2024
 **/

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : BaseViewModel() {

    init {
        getDataPeople()
    }

    private var _page = 1
    val page: Int get() = _page


    private val _isMoviesEmpty = MutableStateFlow(false)
    val isMoviesEmpty: Flow<Boolean> get() = _isMoviesEmpty.asStateFlow()


    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: Flow<List<Movie>> get() = _movies.asStateFlow()

    fun getDataPeople(title: String = DEFAULT_TITLE) {
        setIsLoading(true)
        coroutineScope.launch {
            try {
                 getMoviesUseCase.invoke(title, _page).collect{ result ->
                     when (result) {
                         is Result.Success -> {
                             _movies.emit(result.data.search)
                             _isMoviesEmpty.emit(result.data.search.isEmpty())
                         }
                         is Result.Error -> {
                             _isMoviesEmpty.emit(true)
                         }
                     }
                 }
            } catch (e: Exception) {
                _isMoviesEmpty.emit(true)
            } finally {
                setIsLoading(false)
            }
        }
    }

    fun setPage(page: Int) {
        _page = page
    }

    companion object {
        const val DEFAULT_TITLE = "avenger"
    }
}