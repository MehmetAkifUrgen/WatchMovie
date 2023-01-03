package com.example.watchmovie.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppBar(name: String) {
    TopAppBar() {

    }
}



@Composable
fun Content(){
    Row() {
        Text(text = "Watch Movie")
       Icon(imageVector = Icons.Default.Home, contentDescription ="Home" )
    }
}