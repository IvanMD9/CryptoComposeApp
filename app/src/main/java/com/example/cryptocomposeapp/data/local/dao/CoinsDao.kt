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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoins(
        companyListingEntities: List<ListCoinsEntity>
    )
}