package com.example.cryptocomposeapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite")
data class FavouriteEntity(
    @PrimaryKey val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)
