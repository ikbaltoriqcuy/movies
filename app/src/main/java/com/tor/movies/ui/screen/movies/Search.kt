package com.tor.movies.ui.screen.movies

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
Created by ikbaltoriq on 20,September,2024
 **/

@Preview
@Composable
fun Search() {
    OutlinedTextField(
        value = "search",
        onValueChange = {},
        placeholder = {
            Text(text = "Masukan Judul Film")
        },
        modifier = Modifier.fillMaxWidth()
    )
}