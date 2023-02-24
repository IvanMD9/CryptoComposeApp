package com.example.cryptocomposeapp.domain.repository

import com.example.cryptocomposeapp.domain.model.FavouriteCoin
import kotlinx.coroutines.flow.Flow

interface RepositoryFavouriteCoins {

    fun getListFav() : Flow<List<FavouriteCoin>>
    suspend fun addFavourite(favouriteCoin: FavouriteCoin)
    suspend fun deleteFavourite(favouriteCoin: FavouriteCoin)
}