package com.example.cryptocomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocomposeapp.presentation.detail_coin.CoinDetailWindow
import com.example.cryptocomposeapp.presentation.list_coin.CoinListWindow
import com.example.cryptocomposeapp.ui.theme.CryptoComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoComposeAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavigationScreens.ListScreen.route
                ) {
                    composable(route = NavigationScreens.ListScreen.route) {
                        CoinListWindow(navController = navController)
                    }
                    composable(route = NavigationScreens.DetailScreen.route + "/{coin_detail}") {
                        CoinDetailWindow()
                    }
                }
            }
        }
    }
}