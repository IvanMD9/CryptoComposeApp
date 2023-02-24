package com.example.cryptocomposeapp.di

import com.example.cryptocomposeapp.data.repository.CoinRepositoryImpl
import com.example.cryptocomposeapp.data.repository.FavouriteCoinsRepositoryImpl
import com.example.cryptocomposeapp.domain.repository.RepositoryCoins
import com.example.cryptocomposeapp.domain.repository.RepositoryFavouriteCoins
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideRepositoryCoin(coinRepositoryImpl: CoinRepositoryImpl): RepositoryCoins

    @Binds
    @Singleton
    fun provideRepositoryFavouriteCoins(
        favouriteCoinsRepositoryImpl: FavouriteCoinsRepositoryImpl
    ): RepositoryFavouriteCoins
}