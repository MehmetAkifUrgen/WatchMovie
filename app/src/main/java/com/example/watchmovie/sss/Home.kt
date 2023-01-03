package com.example.watchmovie.sss

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.ActivityNavigatorExtras
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.watchmovie.components.MovieCard


@OptIn(ExperimentalFoundationApi::class)
@Composable


fun Home(homeViewModel: HomeViewModel,navController: NavHostController){



    var id by remember { mutableStateOf("") }
    var data= homeViewModel.noteList.collectAsState().value
    Log.d("data", data.toString())

    Column() {

        LazyVerticalGrid(cells = GridCells.Fixed(2)){
            items(data){key ->
                MovieCard(name = key.title, image ="https://image.tmdb.org/t/p/w500"+ key.poster_path, modifier = Modifier
                    .height(250.dp)
                    .width(75.dp)
                    .padding(10.dp)
                    .clickable {id = key.id.toString(); navController.navigate("detail") })
            }
        }

    }
}


/*
@Composable
fun List(data: StateFlow<List<Result>>){
    LazyColumn{
        items(data){ key ->
            MovieCard(name =key.title , image =key.backdrop_path )
        }
    }
}*/