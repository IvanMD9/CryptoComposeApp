package com.example.cryptocomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cryptocomposeapp.presentation.detail_coin.CoinDetailWindow
import com.example.cryptocomposeapp.presentation.favourite.FavouriteWindow
import com.example.cryptocomposeapp.presentation.list_coin.CoinListWindow
import com.example.cryptocomposeapp.presentation.spalsh_screen.SplashWindow

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationScreens.ListScreen.route
    ) {

//        composable(NavigationScreens.SplashScreen.route) {
//            SplashWindow(navController = navHostController)
//        }

        composable(route = NavigationScreens.ListScreen.route) {
            CoinListWindow(navController = navHostController)
        }
        composable(route = NavigationScreens.DetailScreen.route + "/{coin_detail}") {
            CoinDetailWindow(navController = navHostController)
        }
        composable(NavigationScreens.FavouriteScreen.route) {
            FavouriteWindow()
        }
    }
}