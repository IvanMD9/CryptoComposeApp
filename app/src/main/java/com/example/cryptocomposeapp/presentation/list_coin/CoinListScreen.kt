package com.example.cryptocomposeapp.presentation.list_coin

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocomposeapp.data.mapper.toFavourite
import com.example.cryptocomposeapp.navigation.NavigationScreens
import com.example.cryptocomposeapp.presentation.list_coin.componets.CoinListItem
import com.example.cryptocomposeapp.presentation.list_coin.componets.ShimmerLoadingList
import com.example.cryptocomposeapp.ui.theme.ListCoinColor

@Composable
fun CoinListWindow(
    navController: NavController,
    viewModel: ListCoinsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ListCoinColor)
            .padding(top = 35.dp)
    ) {
        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = {
                viewModel.onEvent(
                    Event.SearchQuery(it)
                )
                Log.d("TAG", "${viewModel.onEvent(Event.SearchQuery(it))} ---- Event.SearchQuery")
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(text = "Search...", color = Color.White)
            },
            maxLines = 1,
            singleLine = true
        )
        Log.d("TAG", "${state.searchQuery} ------- result")
        Spacer(modifier = Modifier.height(15.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 30.dp)
        ) {
            if (state.isLoading) {
                items(20) {
                    ShimmerLoadingList()
                }
            } else {
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
        }
        // Если ошибка, то показать текст с ошибкой
        if (state.error.isNotBlank()) {
            Text(
                text = state.error, color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )
        }
    }
}