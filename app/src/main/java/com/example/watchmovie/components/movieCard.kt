package com.example.watchmovie.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter


@Composable
fun MovieCard(name: String, image: String,modifier: Modifier) {
    Card(
        modifier = modifier,
        elevation = 1.dp,
        border = BorderStroke(0.4.dp, Color.Black),
        shape = RoundedCornerShape(10)
    ) {
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Image(modifier=Modifier.fillMaxWidth().height(200.dp), painter = rememberImagePainter(image), contentDescription =image, alignment = Alignment.Center, contentScale = ContentScale.Crop )
          Text(text = name, fontSize = 14.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
      }
    }
}


