package com.dengun.shopify.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.dengun.shopify.data.local.entity.ProductEntity

@Dao
interface ProductDao : RoomDao<ProductEntity> {

    @Query("SELECT * FROM Product ORDER BY name ASC")
    suspend fun select(): List<ProductEntity>

    @Query("SELECT * FROM Product WHERE id = :id")
    suspend fun selectById(id: Long): ProductEntity
}