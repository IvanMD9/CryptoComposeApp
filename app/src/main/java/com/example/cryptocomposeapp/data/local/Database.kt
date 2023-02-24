package com.example.cryptocomposeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cryptocomposeapp.data.local.dao.CoinsDao
import com.example.cryptocomposeapp.data.local.dao.FavouriteDao
import com.example.cryptocomposeapp.data.local.entity.FavouriteEntity
import com.example.cryptocomposeapp.data.local.entity.ListCoinsEntity

@Database(
    entities = [ListCoinsEntity::class, FavouriteEntity::class],
    version = 1
)
abstract class Database : RoomDatabase() {

    abstract val daoCoins: CoinsDao
    abstract val daoFavourite: FavouriteDao

    companion object {
        const val DB_NAME = "coins_db"
    }
}