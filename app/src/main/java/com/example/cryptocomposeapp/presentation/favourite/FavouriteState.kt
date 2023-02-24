package com.example.cryptocomposeapp.presentation.favourite

import com.example.cryptocomposeapp.domain.model.FavouriteCoin

data class FavouriteState(
    val favourite : List<FavouriteCoin> = emptyList()
)
