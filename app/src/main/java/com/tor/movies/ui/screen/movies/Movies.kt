package com.tor.movies.ui.screen.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.tor.movies.ui.theme.Dimens

/**
Created by ikbaltoriq on 20,September,2024
 **/

@Preview(showSystemUi = true, device = Devices.PIXEL)
@Composable
fun Movies(moviesViewModel: MoviesViewModel = hiltViewModel()) {
    val movies = moviesViewModel.movies.collectAsState(initial = emptyList())
    val isMoviesEmpty = moviesViewModel.isMoviesEmpty.collectAsState(initial = true)
    Column(modifier = Modifier.padding(Dimens.Medium)) {
        Search()
        when {
            isMoviesEmpty.value -> EmptyMovies()
            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(Dimens.Small),
                    contentPadding = PaddingValues(
                        start = Dimens.Medium,
                        end = Dimens.Medium,
                        top = Dimens.Medium
                    )
                ) {
                    items(movies.value) { item ->
                        MovieItem(movie = item)
                    }
                }
            }
        }

    }
}