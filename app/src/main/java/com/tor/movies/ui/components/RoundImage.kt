package com.tor.movies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tor.movies.ui.theme.Dimens

/**
Created by ikbaltoriq on 20,September,2024
 **/

@Composable
fun RoundImage(
    modifier: Modifier = Modifier,
    image: String
) {
    Surface(
        modifier = Modifier
            .size(width = 70.dp, height = 100.dp)
            .clip(shape = RoundedCornerShape(Dimens.Small)),
        border = BorderStroke(Dimens.StrokeBorder, Color.Gray)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(image)
                .crossfade(true)
                .build(),
            contentDescription = "",
            modifier = modifier
        )
    }
}