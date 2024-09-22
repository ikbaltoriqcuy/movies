package com.tor.movies.ui.screen.movies

import androidx.compose.runtime.collectAsState
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
        getMovies()
    }

    private var _page = 1
    val page: Int get() = _page


    private val _isShimmerShow = MutableStateFlow(true)
    val isShimmerShow: Flow<Boolean> get() = _isShimmerShow.asStateFlow()

    private val _isMoviesEmpty = MutableStateFlow(false)
    val isMoviesEmpty: Flow<Boolean> get() = _isMoviesEmpty.asStateFlow()

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: Flow<List<Movie>> get() = _movies.asStateFlow()

    fun getMovies(title: String = DEFAULT_TITLE) {
        coroutineScope.launch {
            try {
                if (_movies.value.isEmpty()) {
                    _isShimmerShow.emit(true)
                }

                getMoviesUseCase.invoke(title, _page).collect{ result ->
                     when (result) {
                         is Result.Success -> {
                             val newData = _movies.value + result.data.search
                             _movies.emit(newData)
                             _isMoviesEmpty.emit(newData.isEmpty())
                         }
                         is Result.Error -> {
                             _isMoviesEmpty.emit(true)
                         }
                     }
                 }

            } catch (e: Exception) {
                _isMoviesEmpty.emit(_movies.value.isEmpty())
            } finally {
                _isShimmerShow.emit(false)
            }
        }
    }



    fun incrementPage() {
        _page = page + 1
    }

    companion object {
        const val DEFAULT_TITLE = "avenger"
    }
}