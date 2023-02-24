package com.example.cryptocomposeapp.data.mapper

import com.example.cryptocomposeapp.data.local.entity.ListCoinsEntity
import com.example.cryptocomposeapp.domain.model.ListCoins

fun ListCoinsEntity.toCoins() : ListCoins {
    return ListCoins(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}

fun ListCoins.toListCoinsEntity() : ListCoinsEntity {
    return ListCoinsEntity(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}