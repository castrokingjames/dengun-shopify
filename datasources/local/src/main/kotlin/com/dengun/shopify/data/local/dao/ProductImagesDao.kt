package com.dengun.shopify.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.dengun.shopify.data.local.entity.ImageEntity
import com.dengun.shopify.data.local.entity.ProductImagesEntity

@Dao
interface ProductImagesDao : RoomDao<ProductImagesEntity> {

    @Query("SELECT Image.* FROM Image JOIN ProductImages ON Image.id = ProductImages.imageId WHERE ProductImages.productId = :productId")
    suspend fun selectByProductId(productId: Long): List<ImageEntity>
}