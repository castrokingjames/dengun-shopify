package com.dengun.shopify.data.repository

import com.dengun.shopify.data.ProductQuantityData
import com.dengun.shopify.data.store.DataStore
import com.dengun.shopify.data.toDomain
import com.dengun.shopify.domain.ProductQuantity
import com.dengun.shopify.domain.repository.ProductQuantityRepository

class ProductQuantityDataRepository(
        local: DataStore<ProductQuantityData>
) : AbstractDataRepository<ProductQuantityData, ProductQuantity>(local), ProductQuantityRepository {

    override fun toDomain(data: ProductQuantityData): ProductQuantity {
        val product = data.product.toDomain()
        val variant = data.variant.map { entry ->
            entry.key.toDomain() to entry.value
        }.toMap()
        return ProductQuantity(product, variant)
    }
}