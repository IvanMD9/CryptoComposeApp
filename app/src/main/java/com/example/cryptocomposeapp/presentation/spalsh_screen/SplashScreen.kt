package com.example.cryptocomposeapp.presentation.spalsh_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.cryptocomposeapp.NavigationScreens
import com.example.cryptocomposeapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashWindow(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(2500)
        navController.navigate(NavigationScreens.ListScreen.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.crypto_photo),
            contentDescription = "Splash photo",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}