package com.example.cryptocomposeapp.presentation.detail_coin

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocomposeapp.presentation.detail_coin.components.CoinTag
import com.example.cryptocomposeapp.presentation.detail_coin.components.TeamList
import com.example.cryptocomposeapp.ui.theme.ListCoinActiveColor
import com.example.cryptocomposeapp.ui.theme.ListCoinColor
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailWindow(
    navController: NavController,
    viewModel: DetailCoinViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ListCoinColor)
            .padding(top = 35.dp)
    ) {
        state.detailCoin?.let { coinDetail ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                // item - рассматривается как колонка
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = com.example.cryptocomposeapp.R.drawable.ic_back_list),
                            contentDescription = "Back list",
                            modifier = Modifier
                                .clickable { navController.navigateUp() }
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "${coinDetail.rank}. ${coinDetail.name} (${coinDetail.symbol})",
                            style = MaterialTheme.typography.h2,
                            color = Color.White,
                            fontSize = 22.sp
                        )
                        Text(
                            text = if (coinDetail.is_active) "active" else "inactive",
                            color = if (coinDetail.is_active) ListCoinActiveColor else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = coinDetail.description,
                        style = MaterialTheme.typography.body2,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    // Вид строки, в которой расположение элементов определяется в зависимости от ширины элементов,
                    // если превышает - переносится на новую строку
                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coinDetail.tags.forEach { tags ->
                            CoinTag(tag = tags)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Team member",
                        style = MaterialTheme.typography.h3,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
                items(coinDetail.team) { team ->
                    TeamList(
                        team = team, modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    // Разделительная черта между элементами
                    Divider(modifier = Modifier.background(Color.White))
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
                    .align(Alignment.Center)
            )
        }
        // Отображать ProgressBar при загрузке
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}