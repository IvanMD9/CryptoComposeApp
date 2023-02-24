package com.example.cryptocomposeapp.presentation.favourite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptocomposeapp.presentation.favourite.componets.CoinFavourite
import com.example.cryptocomposeapp.ui.theme.ListCoinColor

@Composable
fun FavouriteWindow(
    viewModel: FavouriteViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    if (state.favourite.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(ListCoinColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Empty favourite coin",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
    } else {
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
                items(state.favourite) { fav ->
                    CoinFavourite(
                        coinItem = fav,
                        coinDeleteFavourite = { viewModel.deleteFavCoin(fav) }
                    )
                }
            }
        }
    }
}