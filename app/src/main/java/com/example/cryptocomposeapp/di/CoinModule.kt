package com.example.cryptocomposeapp.di

import com.example.cryptocomposeapp.data.remote.api.CoinApi
import com.example.cryptocomposeapp.data.repository.CoinRepositoryImpl
import com.example.cryptocomposeapp.domain.repository.RepositoryCoin
import com.example.cryptocomposeapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoinModule {

    @Provides
    @Singleton
    fun provideApi() : CoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: CoinApi) : RepositoryCoin {
        return CoinRepositoryImpl(api)
    }
}