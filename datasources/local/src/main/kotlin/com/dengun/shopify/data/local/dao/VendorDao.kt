package com.dengun.shopify.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.dengun.shopify.data.local.entity.VendorEntity

@Dao
interface VendorDao : RoomDao<VendorEntity> {

    @Query("SELECT * FROM Vendor ORDER BY name ASC")
    suspend fun select(): List<VendorEntity>

    @Query("SELECT * FROM Vendor WHERE code = :code")
    suspend fun selectById(code: Long): VendorEntity
}