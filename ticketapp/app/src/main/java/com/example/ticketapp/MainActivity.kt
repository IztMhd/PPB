package com.example.ticketapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ticketapp.ui.theme.TicketappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketappTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController)
            }
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login_screen") {
        composable("login_screen") {
            LoginPage(navController)
        }
        composable("main_screen") {
            MainScreen(navController)
        }
        composable("movie_detail/{movieTitle}") { backStackEntry ->
            val movieTitle = backStackEntry.arguments?.getString("movieTitle") ?: ""
            val movie = movies.find { it.title == movieTitle } ?: return@composable
            MovieDetailScreen(navController, movie)
        }
    }
}
