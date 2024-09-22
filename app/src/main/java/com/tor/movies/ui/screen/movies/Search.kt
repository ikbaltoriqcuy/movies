package com.tor.movies.ui.screen.movies

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
Created by ikbaltoriq on 20,September,2024
 **/

@Preview
@Composable
fun Search(onSearch: (String) -> Unit = {}) {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { newText ->
            value = newText
            onSearch(newText)
        },
        placeholder = {
            Text(text = "Masukan Judul Film")
        },
        modifier = Modifier.fillMaxWidth()
    )
}