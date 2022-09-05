package com.example.cryptocomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocomposeapp.presentation.detail_coin.CoinDetailWindow
import com.example.cryptocomposeapp.presentation.list_coin.CoinListWindow
import com.example.cryptocomposeapp.presentation.spalsh_screen.SplashWindow
import com.example.cryptocomposeapp.ui.theme.CryptoComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Нужно для прозрачности statusBar + установка прозрачного цвета в теме приложения
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CryptoComposeAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavigationScreens.SplashScreen.route
                ) {
                    composable(route = NavigationScreens.SplashScreen.route) {
                        SplashWindow(navController = navController)
                    }
                    composable(route = NavigationScreens.ListScreen.route) {
                        CoinListWindow(navController = navController)
                    }
                    composable(route = NavigationScreens.DetailScreen.route + "/{coin_detail}") {
                        CoinDetailWindow(navController = navController)
                    }
                }
            }
        }
    }
}