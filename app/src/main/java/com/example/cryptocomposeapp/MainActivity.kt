package com.example.cryptocomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cryptocomposeapp.navigation.AppNavGraph
import com.example.cryptocomposeapp.navigation.ButtonNavItem
import com.example.cryptocomposeapp.navigation.rememberNavigationState
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
                val navigationState = rememberNavigationState()
                Scaffold(
                    bottomBar = {
                        BottomNavigation(modifier = Modifier.height(90.dp)) {
                            val backStackEntry by navigationState.navHostController.currentBackStackEntryAsState()

                            val items = listOf(
                                ButtonNavItem.List,
                                ButtonNavItem.Favourites,
                            )
                            items.forEach { item ->

                                val selected = backStackEntry?.destination?.hierarchy?.any {
                                    it.route == item.route
                                } ?: false

                                BottomNavigationItem(
                                    selected = selected,
                                    onClick = { if (!selected) navigationState.navigateTo(item.route) },
                                    selectedContentColor = Color.White,
                                    unselectedContentColor = Color.Gray,
                                    icon = {
                                        Icon(
                                            painter = painterResource(id = item.image),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .padding(bottom = 45.dp)
                                        )
                                    }
                                )
                            }
                        }
                    }
                ) {
                    AppNavGraph(navHostController = navigationState.navHostController)
                }
            }
        }
    }
}