package com.tor.movies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tor.movies.R
import com.tor.movies.ui.theme.Dimens

/**
Created by ikbaltoriq on 20,September,2024
 **/

@Preview
@Composable
fun RoundImage(
    modifier: Modifier = Modifier,
    drawable: Int = R.drawable.ic_launcher_background
) {
    Surface(
        modifier = Modifier
            .size(width = 60.dp, height = 100.dp)
            .clip(shape = RoundedCornerShape(Dimens.Small)),
        border = BorderStroke(Dimens.StrokeBorder, Color.Gray)
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "",
            modifier = modifier
        )
    }
}