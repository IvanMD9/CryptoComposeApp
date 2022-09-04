package com.example.cryptocomposeapp.data.repository

import com.example.cryptocomposeapp.data.remote.api.CoinApi
import com.example.cryptocomposeapp.data.remote.model.CoinItemDetailModel
import com.example.cryptocomposeapp.data.remote.model.ListCoinModelItem
import com.example.cryptocomposeapp.domain.repository.RepositoryCoin
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : RepositoryCoin {

    override suspend fun getListCoins(): List<ListCoinModelItem> {
        return api.getListCoins()
    }

    override suspend fun getDetailCoin(id: String): CoinItemDetailModel {
        return api.getItemDetailCoin(id)
    }
}