package com.example.cryptocomposeapp.presentation.list_coin.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cryptocomposeapp.ui.theme.ListCoinColor
import com.example.cryptocomposeapp.ui.theme.ListCoinColor2
import com.valentinilk.shimmer.shimmer

@Composable
fun ShimmerLoadingList() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shimmer()
            .background(ListCoinColor)
            .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically)
    {
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(25.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(ListCoinColor2)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Box(
            modifier = Modifier
                .width(70.dp)
                .height(25.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(ListCoinColor2)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Box(modifier = Modifier
            .padding(vertical = 10.dp)
            .size(35.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(ListCoinColor2))
    }
}

@Preview
@Composable
fun ShimmerLoadingListPreview() {
    ShimmerLoadingList()
}