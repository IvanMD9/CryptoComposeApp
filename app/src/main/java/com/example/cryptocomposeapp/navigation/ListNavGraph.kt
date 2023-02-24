package com.example.cryptocomposeapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.cryptocomposeapp.presentation.detail_coin.CoinDetailWindow
import com.example.cryptocomposeapp.presentation.list_coin.CoinListWindow

fun NavGraphBuilder.listNavGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = NavigationScreens.ListScreen.route,
        route = NavigationScreens.ListScreen.route
    ) {
        composable(route = NavigationScreens.ListScreen.route) {
            CoinListWindow(navController = navHostController)
        }
        composable(route = NavigationScreens.DetailScreen.route + "/{coin_detail}") {
            CoinDetailWindow(navController = navHostController)
        }
    }
}