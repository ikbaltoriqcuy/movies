package com.tor.movies.ui.screen.movies

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tor.movies.ui.theme.Dimens

/**
Created by ikbaltoriq on 22,September,2024
 **/


@Composable
fun ShimmerMovies() {
    val widthOfShadowBrush = 500
    val angleOfAxisY = 270f
    val durationMillis = 1000

    val shimmerColors = listOf(
        Color.Gray.copy(alpha = 0.3f),
        Color.Gray.copy(alpha = 0.5f),
        Color.Gray.copy(alpha = 1.0f),
        Color.Gray.copy(alpha = 0.5f),
        Color.Gray.copy(alpha = 0.3f),
    )

    val transition = rememberInfiniteTransition(label = "")

    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = (durationMillis + widthOfShadowBrush).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Restart,
        ),
        label = "Shimmer loading animation",
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(x = translateAnimation.value - widthOfShadowBrush, y = 0.0f),
        end = Offset(x = translateAnimation.value, y = angleOfAxisY),
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(Dimens.Small),
        contentPadding = PaddingValues(
            start = Dimens.Medium,
            end = Dimens.Medium,
            top = Dimens.Medium
        )
    ) {
        items(10) { item ->
            ShimmerMovieItem(brush)
        }
    }
}

@Composable
fun ShimmerMovieItem(brush: Brush) {
    Row {
        Box(
            modifier = Modifier
                .size(width = 70.dp, height = 100.dp)
                .clip(shape = RoundedCornerShape(Dimens.Small))
                .background(brush)
        )
        Column(
            modifier = Modifier.padding(start = Dimens.Small, end = Dimens.Small)
        ) {
            Box( modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .clip(shape = RoundedCornerShape(Dimens.Small))
                .background(brush)
            )
            Box(modifier = Modifier
                .padding(top = Dimens.Small)
                .width(40.dp)
                .height(20.dp)
                .clip(shape = RoundedCornerShape(Dimens.Small))
                .background(brush)
            )
        }
    }
}
