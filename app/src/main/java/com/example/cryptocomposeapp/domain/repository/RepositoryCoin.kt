package com.example.cryptocomposeapp.domain.repository

import com.example.cryptocomposeapp.data.remote.model.CoinItemDetailModel
import com.example.cryptocomposeapp.data.remote.model.ListCoinModelItem

interface RepositoryCoin {

    suspend fun getListCoins() : List<ListCoinModelItem>
    suspend fun getDetailCoin(id : String) : CoinItemDetailModel
}