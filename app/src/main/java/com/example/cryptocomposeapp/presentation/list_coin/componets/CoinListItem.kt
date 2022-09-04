package com.example.cryptocomposeapp.presentation.list_coin.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.cryptocomposeapp.domain.model.ListCoins

@Composable
fun CoinListItem(
    coinItem: ListCoins,
    coinClickItem: () -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { coinClickItem() }
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween)
    {
        Text(
            text = "${coinItem.rank}. ${coinItem.name} (${coinItem.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = if (coinItem.is_active) "active" else "inactive",
            color = if (coinItem.is_active) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }
}