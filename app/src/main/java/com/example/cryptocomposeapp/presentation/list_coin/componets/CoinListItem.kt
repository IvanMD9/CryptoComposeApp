package com.example.cryptocomposeapp.presentation.list_coin.componets

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.cryptocomposeapp.R
import com.example.cryptocomposeapp.domain.model.ListCoins
import com.example.cryptocomposeapp.ui.theme.ListCoinActiveColor

@Composable
fun CoinListItem(
    coinItem: ListCoins,
    coinClickItem: () -> Unit,
    coinAddFavourite: () -> Unit,
    //isAddFavourite: Boolean
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
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
        Text(
            text = if (coinItem.is_active) "active" else "inactive",
            color = if (coinItem.is_active) ListCoinActiveColor else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
        Image(
            painter = painterResource(id = R.drawable.add_fav),
            contentDescription = null,
            modifier = Modifier.clickable { coinAddFavourite() })
    }
}