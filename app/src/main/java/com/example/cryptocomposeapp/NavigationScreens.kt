package com.example.cryptocomposeapp

sealed class NavigationScreens(val route : String) {
    object ListScreen : NavigationScreens("list_screen")
    object DetailScreen : NavigationScreens("detail_screen")
    object SplashScreen : NavigationScreens("splash_screen")
}
