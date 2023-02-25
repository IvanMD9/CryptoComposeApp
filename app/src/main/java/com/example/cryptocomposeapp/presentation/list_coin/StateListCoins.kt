package com.example.cryptocomposeapp.presentation.list_coin

import com.example.cryptocomposeapp.domain.model.ListCoins

data class StateListCoins(
    val isLoading : Boolean = false,
    val listCoins : List<ListCoins> = emptyList(),
    val error : String = "",
    val searchQuery : String = ""
)
