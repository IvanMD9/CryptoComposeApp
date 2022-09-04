package com.example.cryptocomposeapp.domain.model

data class ListCoins(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)
