package com.example.cryptocomposeapp.presentation.spalsh_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cryptocomposeapp.navigation.NavigationScreens
import com.example.cryptocomposeapp.R
import com.example.cryptocomposeapp.ui.theme.ListCoinColor
import kotlinx.coroutines.delay

@Composable
fun SplashWindow(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(3500)
        navController.navigate(NavigationScreens.ListScreen.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ListCoinColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "List of cryptocurrencies",
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(id = R.drawable.crypto_photo),
                contentDescription = "Splash photo",
                alignment = Alignment.Center
            )
        }
    }
}