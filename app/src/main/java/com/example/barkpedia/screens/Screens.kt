package com.example.barkpedia.screens

import kotlinx.parcelize.Parcelize

sealed class Screens(val route: String) {
    object SplashScreen: Screens("splash_screen")
    object HomeScreen: Screens("home_screen")
    object DetailScreen: Screens("detail_screen")
    object FavScreen: Screens("fav_screen")
}