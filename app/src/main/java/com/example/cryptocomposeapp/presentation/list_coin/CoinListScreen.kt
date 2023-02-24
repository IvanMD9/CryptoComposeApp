package com.example.cryptocomposeapp.presentation.list_coin

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocomposeapp.data.mapper.toFavourite
import com.example.cryptocomposeapp.navigation.NavigationScreens
import com.example.cryptocomposeapp.presentation.list_coin.componets.CoinListItem
import com.example.cryptocomposeapp.ui.theme.ListCoinColor
import kotlinx.coroutines.launch

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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 30.dp)
        ) {
            items(state.listCoins) { coin ->
                CoinListItem(
                    coinItem = coin,
                    coinClickItem = {
                        navController.navigate(NavigationScreens.DetailScreen.route + "/${coin.id}")
                    },
                    coinAddFavourite = {
                        viewModel.addFavourite(coin.toFavourite())
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