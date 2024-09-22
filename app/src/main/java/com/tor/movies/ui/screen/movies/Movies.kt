package com.tor.movies.ui.screen.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.tor.movies.repository.model.Movie
import com.tor.movies.ui.theme.Dimens

/**
Created by ikbaltoriq on 20,September,2024
 **/

@Preview(showSystemUi = true, device = Devices.PIXEL)
@Composable
fun Movies() {
    val sampleItems = listOf(
        Movie(
            "The Drifting Avenger",
            "1968",
            "tt0130639",
            "moview",
            "https://m.media-amazon.com/images/M/MV5BOWIwZGM2YWUtMDA0Ny00M2I4LWFlN2MtZDE0OTMxZTQyZWQ3XkEyXkFqcGdeQXVyMjk2MDM1MzY@._V1_SX300.jpg"
        )
    )

    Column(modifier = Modifier.padding(Dimens.Medium)) {
        Search()
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimens.Small),
            contentPadding = PaddingValues(start = Dimens.Medium, end = Dimens.Medium, top = Dimens.Medium)
        ) {
            items(sampleItems.size) { index ->
                MovieItem(movie = sampleItems[index])
            }
        }

    }
}