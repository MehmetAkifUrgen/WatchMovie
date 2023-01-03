package com.example.watchmovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.watchmovie.components.AppBar
import com.example.watchmovie.components.MovieCard
import com.example.watchmovie.sss.Home
import com.example.watchmovie.sss.HomeViewModel
import com.example.watchmovie.sss.MovieDetail
import com.example.watchmovie.ui.theme.WatchMovieTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            WatchMovieTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Scaffold(topBar = { AppBar(name = "WatchMovie") }, bottomBar = {
                        NavBar(
                            navController
                        )
                    }) {

                        Navigation(navController)


                    }
                }
            }
        }
    }


}

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            Home(homeViewModel = HomeViewModel(),navController)
            /*...*/
        }

    }
}

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            Home(homeViewModel = HomeViewModel(),navController)
        }
        composable(route = "detail") {
            MovieDetail()
        }
    }
}

@Composable
private fun NavBar(navController: NavHostController) {

    BottomAppBar {

        // Leading icons should typically have a high content alpha
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { navController.navigate("home") }) {
                Icon(image = Icons.Default.Home, desc = "Home", tint = Color.White)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(image = Icons.Default.Favorite, desc = "profile", tint = Color.White)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(image = Icons.Default.Search, desc = "Search", tint = Color.White)
            }
        }
    }
}

@Composable
private fun Icon(image: ImageVector, desc: String, tint: Color) {
    Icon(imageVector = image, contentDescription = desc, tint = tint)
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WatchMovieTheme {
        MovieCard(name = "akif", image = "asds")
    }
}*/