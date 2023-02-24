package com.example.cryptocomposeapp.data.mapper

import com.example.cryptocomposeapp.data.local.entity.FavouriteEntity
import com.example.cryptocomposeapp.domain.model.FavouriteCoin
import com.example.cryptocomposeapp.domain.model.ListCoins

fun FavouriteCoin.toFavouriteEntity(): FavouriteEntity {
    return FavouriteEntity(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}

fun FavouriteEntity.toFavouriteCoin(): FavouriteCoin {
    return FavouriteCoin(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}

fun ListCoins.toFavourite(): FavouriteCoin {
    return FavouriteCoin(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}