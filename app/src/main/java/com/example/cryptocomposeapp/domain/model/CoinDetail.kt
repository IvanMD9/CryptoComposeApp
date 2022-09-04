package com.example.cryptocomposeapp.domain.model

import com.example.cryptocomposeapp.data.remote.model.*

data class CoinDetail(
    val description: String,
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<Team>
)
