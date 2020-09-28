package com.dengun.shopify.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.dengun.shopify.data.local.entity.ProductVendorEntity
import com.dengun.shopify.data.local.entity.VendorEntity

@Dao
interface ProductVendorDao : RoomDao<ProductVendorEntity> {

    @Query("SELECT Vendor.* FROM Vendor JOIN ProductVendor ON Vendor.code = ProductVendor.vendorCode WHERE ProductVendor.productId = :productId")
    suspend fun selectByProductId(productId: Long): VendorEntity
}