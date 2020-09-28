package com.dengun.shopify.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.dengun.shopify.data.local.entity.ProductQuantityEntity

@Dao
interface ProductQuantityDao : RoomDao<ProductQuantityEntity> {

    @Query("SELECT * FROM ProductQuantity WHERE variantId = :variantId")
    suspend fun selectByVariantId(variantId: Long): ProductQuantityEntity
}