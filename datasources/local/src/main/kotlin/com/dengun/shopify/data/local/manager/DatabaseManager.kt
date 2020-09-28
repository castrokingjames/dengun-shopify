package com.dengun.shopify.data.local.manager

import com.dengun.shopify.data.local.dao.*

interface DatabaseManager {

    fun imageDao(): ImageDao

    fun productDao(): ProductDao

    fun productImagesDao(): ProductImagesDao

    fun productQuantityDao(): ProductQuantityDao

    fun productsTagsDao(): ProductsTagsDao

    fun productVariantsDao(): ProductVariantsDao

    fun productVendorDao(): ProductVendorDao

    fun tagDao(): TagDao

    fun variantDao(): VariantDao

    fun vendorDao(): VendorDao
}