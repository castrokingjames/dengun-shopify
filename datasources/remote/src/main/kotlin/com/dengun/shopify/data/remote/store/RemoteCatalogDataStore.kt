package com.dengun.shopify.data.remote.store

import com.dengun.shopify.data.CatalogData
import com.dengun.shopify.data.ProductQuantityData
import com.dengun.shopify.data.TagData
import com.dengun.shopify.data.remote.productQuantityData
import com.dengun.shopify.data.remote.service.ShopifyService
import com.dengun.shopify.data.remote.tags
import com.dengun.shopify.data.store.DataStore
import javax.inject.Inject
import javax.inject.Named

class RemoteCatalogDataStore @Inject constructor(
        @Named("SHOPIFY_API_KEY") private val apiKey: String,
        private val shopifyService: ShopifyService
) : DataStore<CatalogData> {

    override suspend fun load(): List<CatalogData> {
        val map = hashMapOf<TagData, MutableList<ProductQuantityData>>()
        shopifyService
                .load(1, apiKey)
                .products
                .forEach { response ->
                    val productQuantityData = response.productQuantityData()
                    response
                            .tags()
                            .forEach { tag ->
                                val list: MutableList<ProductQuantityData> = map[tag]
                                        ?: run {
                                            val list = mutableListOf<ProductQuantityData>()
                                            map[tag] = list
                                            list
                                        }
                                list.add(productQuantityData)
                            }
                }
        return map.map { (key, value) -> CatalogData(key, value) }.sortedBy { catalog -> catalog.tag.name }
    }

    override suspend fun save(users: List<CatalogData>) {
        throw UnsupportedOperationException("save() is not supported")
    }

    override suspend fun loadById(id: Any): List<CatalogData> {
        throw UnsupportedOperationException("loadByTrackId() is not supported")
    }
}