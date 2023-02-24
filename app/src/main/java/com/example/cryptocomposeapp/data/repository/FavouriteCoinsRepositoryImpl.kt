package com.example.cryptocomposeapp.data.repository

import com.example.cryptocomposeapp.data.local.Database
import com.example.cryptocomposeapp.data.mapper.toFavouriteCoin
import com.example.cryptocomposeapp.data.mapper.toFavouriteEntity
import com.example.cryptocomposeapp.domain.model.FavouriteCoin
import com.example.cryptocomposeapp.domain.repository.RepositoryFavouriteCoins
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouriteCoinsRepositoryImpl @Inject constructor(
    db: Database
) : RepositoryFavouriteCoins {

    private val dao = db.daoFavourite

    override fun getListFav(): Flow<List<FavouriteCoin>> {
        return dao.getAllFavourites().map { it.map { fav -> fav.toFavouriteCoin() } }
    }

    override suspend fun addFavourite(favouriteCoin: FavouriteCoin) {
        return dao.addFavCoins(favouriteCoin.toFavouriteEntity())
    }

    override suspend fun deleteFavourite(favouriteCoin: FavouriteCoin) {
        return dao.deleteFavourite(favouriteCoin.toFavouriteEntity())
    }
}