package com.example.cryptocomposeapp.data.remote.model

import com.example.cryptocomposeapp.domain.model.ListCoins

data class ListCoinModelItem(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

fun ListCoinModelItem.toListCoins() : ListCoins {
    return ListCoins(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}