package com.example.cryptocomposeapp.data.remote.api

import com.example.cryptocomposeapp.data.remote.model.CoinItemDetailModel
import com.example.cryptocomposeapp.data.remote.model.ListCoinModelItem
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getListCoins() : List<ListCoinModelItem>

    @GET("/v1/coins/{coin_detail}")
    suspend fun getItemDetailCoin(@Path("coin_detail") id : String) : CoinItemDetailModel
}