package com.tor.movies.ui.screen.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tor.movies.ui.theme.Dimens
import kotlinx.coroutines.launch

/**
Created by ikbaltoriq on 20,September,2024
 **/

@Preview(showSystemUi = true, device = Devices.PIXEL)
@Composable
fun Movies(moviesViewModel: MoviesViewModel = hiltViewModel()) {
    val lazyListState = rememberLazyListState()

    val movies = moviesViewModel.movies.collectAsState(initial = emptyList())
    val moviesFiltered = moviesViewModel.filteredMovies.collectAsState(initial = emptyList())
    val isShimmerShow = moviesViewModel.isShimmerShow.collectAsState(initial = true)
    val isMoviesEmpty = moviesViewModel.isMoviesEmpty.collectAsState(initial = true)
    val isOnSearch = moviesViewModel.isOnSearch.collectAsState(initial = true)
    val errorMessage = moviesViewModel.errorMessage.collectAsState(initial = "")

    Column(modifier = Modifier.padding(Dimens.Medium)) {
        Spacer(modifier = Modifier.height(60.dp))
        Search{ value ->  moviesViewModel.search(value) }
        when {
            isShimmerShow.value -> ShimmerMovies()
            errorMessage.value.isNotEmpty() -> ErrorScreen(errorMessage = errorMessage.value) { moviesViewModel.getMovies() }
            isMoviesEmpty.value -> EmptyMovies()
            else -> {
                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(Dimens.Small),
                    contentPadding = PaddingValues(
                        start = Dimens.Medium,
                        end = Dimens.Medium,
                        top = Dimens.Medium
                    )
                ) {
                    val currentMovies = if (isOnSearch.value) moviesFiltered else movies
                    items(currentMovies.value) { item ->
                        MovieItem(movie = item)
                    }

                    item {
                        if (!isOnSearch.value)
                            CircularLoadingIndicator()
                    }

                }
            }
        }

    }

    LaunchedEffect(lazyListState) {
        snapshotFlow { lazyListState.layoutInfo }
            .collect { layoutInfo ->
                val lastVisibleItemIndex = layoutInfo.visibleItemsInfo.lastOrNull()?.index
                if (lastVisibleItemIndex == layoutInfo.totalItemsCount - 1) {
                    launch {
                        if (movies.value.isNotEmpty()) {
                            moviesViewModel.incrementPage()
                            moviesViewModel.getMovies()
                        }
                    }
                }
            }
    }
}

@Composable
fun CircularLoadingIndicator() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}