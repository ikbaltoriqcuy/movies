package com.tor.movies.ui.screen.movies

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.tor.movies.R
import com.tor.movies.ui.theme.AppTypography
import com.tor.movies.ui.theme.Dimens

/**
Created by ikbaltoriq on 22,September,2024
 **/

@Preview(showSystemUi = true, device = Devices.PIXEL)
@Composable
fun ErrorScreen(errorMessage: String = "Error", onRetry: ()-> Unit = {}) {
    Box(modifier = Modifier.fillMaxSize().background(Color.White), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.padding(Dimens.Large),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.illustration_error),
                contentDescription = ""
            )
            Text(
                modifier = Modifier.padding(Dimens.Medium),
                text = errorMessage,
                style = AppTypography.titleLarge
            )

            Button(modifier = Modifier.fillMaxWidth(), onClick = { onRetry.invoke() }) {
                Text(text = "Retry...", style = AppTypography.bodyLarge)
            }
        }


    }
}