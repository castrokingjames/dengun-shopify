package com.dengun.shopify.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.dengun.shopify.data.local.entity.ProductEntity
import com.dengun.shopify.data.local.entity.ProductsTagsEntity

@Dao
interface ProductsTagsDao : RoomDao<ProductsTagsEntity> {

    @Query("SELECT Product.* FROM Product JOIN ProductsTags ON Product.id = ProductsTags.productId WHERE ProductsTags.tagCode = :tagCode")
    suspend fun selectByTagCode(tagCode: String): List<ProductEntity>
}