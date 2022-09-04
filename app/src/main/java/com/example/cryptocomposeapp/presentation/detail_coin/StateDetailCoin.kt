package com.example.cryptocomposeapp.presentation.detail_coin

import com.example.cryptocomposeapp.domain.model.CoinDetail

data class StateDetailCoin(
    val isLoading : Boolean = false,
    val detailCoin : CoinDetail? = null,
    val error : String = ""
)
