package com.example.cryptocomposeapp.data.local.dao

import androidx.room.*
import com.example.cryptocomposeapp.data.local.entity.FavouriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDao {

    @Query("SELECT * FROM favourite")
    fun getAllFavourites() : Flow<List<FavouriteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavCoins(favouriteEntity: FavouriteEntity)

    @Delete
    suspend fun deleteFavourite(favouriteEntity: FavouriteEntity)
}