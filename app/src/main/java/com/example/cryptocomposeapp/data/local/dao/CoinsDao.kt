package com.example.cryptocomposeapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptocomposeapp.data.local.entity.ListCoinsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinsDao {
    @Query("SELECT * FROM coins")
    fun getAllCoins() : Flow<List<ListCoinsEntity>>

    @Query("SELECT * FROM coins WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR UPPER(:query)")
    suspend fun searchCoins(query: String): List<ListCoinsEntity>

    @Query("DELETE FROM coins")
    suspend fun clearCoins()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoins(companyListingEntities: List<ListCoinsEntity>)
}