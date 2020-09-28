package com.dengun.shopify.data.local.store

import com.dengun.shopify.data.CatalogData
import com.dengun.shopify.data.ProductQuantityData
import com.dengun.shopify.data.local.dao.*
import com.dengun.shopify.data.local.entity.*
import com.dengun.shopify.data.local.tag
import com.dengun.shopify.data.local.toData
import com.dengun.shopify.data.local.toEntity
import com.dengun.shopify.data.store.DataStore
import javax.inject.Inject

class LocalCatalogDataStore @Inject constructor(
        private val tagDao: TagDao,
        private val productDao: ProductDao,
        private val vendorDao: VendorDao,
        private val imageDao: ImageDao,
        private val variantDao: VariantDao,
        private val productsTagsDao: ProductsTagsDao,
        private val productImagesDao: ProductImagesDao,
        private val productVendorDao: ProductVendorDao,
        private val productVariantsDao: ProductVariantsDao,
        private val productQuantityDao: ProductQuantityDao
) : DataStore<CatalogData> {

    override suspend fun load(): List<CatalogData> {
        return tagDao.select().map { tagEntity ->
            val tagCode = tagEntity.code
            val tag = tagEntity.toData()
            val productEntities = productsTagsDao.selectByTagCode(tagCode)
            val product = productEntities.map { productEntity ->
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
            CatalogData(tag, product)
        }
    }

    override suspend fun save(data: List<CatalogData>) {
        val tags = mutableListOf<TagEntity>()
        val products = mutableListOf<ProductEntity>()
        val vendors = mutableListOf<VendorEntity>()
        val images = mutableListOf<ImageEntity>()
        val variants = mutableListOf<VariantEntity>()
        val productsTags = mutableListOf<ProductsTagsEntity>()
        val productImages = mutableListOf<ProductImagesEntity>()
        val productVendor = mutableListOf<ProductVendorEntity>()
        val productVariants = mutableListOf<ProductVariantsEntity>()
        val productQuantity = mutableListOf<ProductQuantityEntity>()
        data.forEach { catalog ->
            val tag = catalog.tag()
            val tagCode = tag.code
            val tagEntity = tag.toEntity()
            tags.add(tagEntity)
            catalog
                    .products
                    .forEach { data ->
                        val product = data.product
                        val productId = product.id

                        val productEntity = product.toEntity()
                        products.add(productEntity)

                        val productsTagsEntity = ProductsTagsEntity(productId, tagCode)
                        productsTags.add(productsTagsEntity)

                        val vendor = product.vendor
                        val vendorCode = vendor.code
                        val vendorEntity = vendor.toEntity()
                        vendors.add(vendorEntity)

                        val productVendorEntity = ProductVendorEntity(productId, vendorCode)
                        productVendor.add(productVendorEntity)

                        data
                                .variant
                                .forEach { entry ->
                                    val variant = entry.key
                                    val variantId = variant.id
                                    val variantEntity = variant.toEntity()
                                    variants.add(variantEntity)

                                    val productVariantsEntity = ProductVariantsEntity(productId, variantId)
                                    productVariants.add(productVariantsEntity)

                                    val quantity = entry.value
                                    val productQuantityEntity = ProductQuantityEntity(variantId, quantity)
                                    productQuantity.add(productQuantityEntity)
                                }

                        product
                                .images
                                .forEach { image ->
                                    val imageId = image.id
                                    val imageEntity = image.toEntity()
                                    images.add(imageEntity)

                                    val productImagesEntity = ProductImagesEntity(productId, imageId)
                                    productImages.add(productImagesEntity)
                                }
                    }
        }
        tagDao.insert(tags)
        productDao.insert(products)
        vendorDao.insert(vendors)
        imageDao.insert(images)
        variantDao.insert(variants)
        productsTagsDao.insert(productsTags)
        productImagesDao.insert(productImages)
        productVendorDao.insert(productVendor)
        productVariantsDao.insert(productVariants)
        productQuantityDao.insert(productQuantity)
    }

    override suspend fun loadById(id: Any): List<CatalogData> {
        return mutableListOf()
    }
}