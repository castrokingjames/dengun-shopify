package com.dengun.shopify.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.dengun.shopify.data.local.entity.ProductVariantsEntity
import com.dengun.shopify.data.local.entity.VariantEntity

@Dao
interface ProductVariantsDao : RoomDao<ProductVariantsEntity> {

    @Query("SELECT Variant.* FROM Variant JOIN ProductVariants ON Variant.id = ProductVariants.variantId WHERE ProductVariants.productId = :productId")
    suspend fun selectByProductId(productId: Long): List<VariantEntity>
}