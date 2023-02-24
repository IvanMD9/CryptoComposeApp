package com.example.cryptocomposeapp.di

import android.app.Application
import androidx.room.Room
import com.example.cryptocomposeapp.data.local.Database
import com.example.cryptocomposeapp.data.remote.api.CoinApi
import com.example.cryptocomposeapp.data.repository.CoinRepositoryImpl
import com.example.cryptocomposeapp.data.repository.FavouriteCoinsRepositoryImpl
import com.example.cryptocomposeapp.domain.repository.RepositoryCoins
import com.example.cryptocomposeapp.domain.repository.RepositoryFavouriteCoins
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
object AppModule {

    @Provides
    @Singleton
    fun provideCoinApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): Database {
        return Room.databaseBuilder(
            app,
            Database::class.java,
            Database.DB_NAME
        ).build()
    }
}