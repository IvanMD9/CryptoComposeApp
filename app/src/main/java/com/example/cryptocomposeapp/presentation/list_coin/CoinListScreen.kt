package com.example.cryptocomposeapp.presentation.list_coin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocomposeapp.NavigationScreens
import com.example.cryptocomposeapp.presentation.list_coin.componets.CoinListItem
import com.example.cryptocomposeapp.ui.theme.ListCoinActiveColor
import com.example.cryptocomposeapp.ui.theme.ListCoinColor

@Composable
fun CoinListWindow(
    navController: NavController,
    viewModel: ListCoinsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ListCoinColor)
            .padding(top = 35.dp)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.listCoins) { coin ->
                CoinListItem(
                    coinItem = coin,
                    coinClickItem = {
                        navController.navigate(NavigationScreens.DetailScreen.route + "/${coin.id}")
                    }
                )
            }
        }
        // Если ошибка, то показать текст с ошибкой
        if (state.error.isNotBlank()) {
            Text(
                text = state.error, color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center)
            )
        }
        // Отображать ProgressBar при загрузке
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}