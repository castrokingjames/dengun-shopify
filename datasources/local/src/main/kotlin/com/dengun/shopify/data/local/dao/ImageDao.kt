package com.dengun.shopify.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.dengun.shopify.data.local.entity.ImageEntity

@Dao
interface ImageDao : RoomDao<ImageEntity> {

    @Query("SELECT * FROM Image")
    suspend fun select(): List<ImageEntity>

    @Query("SELECT * FROM Image WHERE id = :id")
    suspend fun selectById(id: Long): ImageEntity
}