package com.tor.movies.ui.screen.movies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tor.movies.repository.model.Movie
import com.tor.movies.ui.components.RoundImage
import com.tor.movies.ui.theme.AppTypography
import com.tor.movies.ui.theme.Dimens

/**
Created by ikbaltoriq on 20,September,2024
 **/

@Composable
fun MovieItem(
    movie: Movie
) {
    Row {
        RoundImage(image = movie.poster)
        Column(
            modifier = Modifier.padding(start = Dimens.Small, end = Dimens.Small)
        ) {
            Text(text = movie.title, style = AppTypography.bodyLarge)
            Text(text = movie.year,  style = AppTypography.bodySmall)
        }
    }
}
