package com.example.cryptocomposeapp.navigation

sealed class NavigationScreens(val route : String) {
    object ListScreen : NavigationScreens(LIST_SCREEN)
    object DetailScreen : NavigationScreens(DETAIL_SCREEN)
    object SplashScreen : NavigationScreens(SPLASH_SCREEN)
    object FavouriteScreen : NavigationScreens(FAVOURITE_SCREEN)

    companion object {
        const val LIST_SCREEN = "list_screen"
        const val DETAIL_SCREEN = "detail_screen"
        const val SPLASH_SCREEN = "splash_screen"
        const val FAVOURITE_SCREEN = "favourite_screen"
    }
}
