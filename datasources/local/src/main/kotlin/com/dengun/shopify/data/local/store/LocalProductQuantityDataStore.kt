package com.dengun.shopify.data.local.store

import com.dengun.shopify.data.ProductQuantityData
import com.dengun.shopify.data.local.dao.*
import com.dengun.shopify.data.local.toData
import com.dengun.shopify.data.store.DataStore
import javax.inject.Inject

class LocalProductQuantityDataStore @Inject constructor(
        private val productsTagsDao: ProductsTagsDao,
        private val productImagesDao: ProductImagesDao,
        private val productVendorDao: ProductVendorDao,
        private val productVariantsDao: ProductVariantsDao,
        private val productQuantityDao: ProductQuantityDao
) : DataStore<ProductQuantityData> {

    override suspend fun load(): List<ProductQuantityData> {
        return mutableListOf()
    }

    override suspend fun save(data: List<ProductQuantityData>) {

    }

    override suspend fun loadById(id: Any): List<ProductQuantityData> {
        val productEntities = productsTagsDao.selectByTagCode(id as String)
        return productEntities.map { productEntity ->
            val productId = productEntity.id
            val vendor = productVendorDao.selectByProductId(productId).toData()
            val images = productImagesDao.selectByProductId(productId).map { imageEntity -> imageEntity.toData() }
            val variants = productVariantsDao.selectByProductId(productId).map { variantEntity -> variantEntity.toData() }
            val product = productEntity.toData(vendor, images)
            val map = variants.map { variant ->
                val variantId = variant.id
                val quantity = productQuantityDao.selectByVariantId(variantId).quantity
                variant to quantity
            }.toMap()
            ProductQuantityData(product, map)
        }
    }
}