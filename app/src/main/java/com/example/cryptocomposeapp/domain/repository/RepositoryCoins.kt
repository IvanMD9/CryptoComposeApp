package com.example.cryptocomposeapp.domain.repository

import com.example.cryptocomposeapp.data.remote.model.CoinItemDetailModel
import com.example.cryptocomposeapp.domain.model.ListCoins
import com.example.cryptocomposeapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RepositoryCoins {
    fun getListCoins() : Flow<Resource<List<ListCoins>>>
    suspend fun getDetailCoin(id : String) : CoinItemDetailModel
}