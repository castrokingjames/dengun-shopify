package com.dengun.shopify.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.dengun.shopify.data.local.entity.VariantEntity

@Dao
interface VariantDao : RoomDao<VariantEntity> {

    @Query("SELECT * FROM Variant ORDER BY name ASC")
    suspend fun select(): List<VariantEntity>

    @Query("SELECT * FROM Variant WHERE id = :id")
    suspend fun selectById(id: Long): VariantEntity
}