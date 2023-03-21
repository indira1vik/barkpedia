package com.example.barkpedia.navigation

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.barkpedia.MainView
import com.example.barkpedia.data.DogsItem
import com.example.barkpedia.screens.*

@Composable
fun NavGraph(viewModel: MainView){
    val navController = rememberNavController()
    val favList = remember { mutableStateListOf<DogsItem>() }
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(Screens.DetailScreen.route) {
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<DogsItem>("dogItem")
            if (result != null) {
                DetailScreen(result,favList)
            }
        }
        composable(Screens.FavScreen.route) {
            FavScreen(navController = navController,favList)
        }
    }
}