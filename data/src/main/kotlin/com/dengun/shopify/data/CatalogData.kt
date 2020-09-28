package com.dengun.shopify.data

data class CatalogData(
        val tag: TagData,
        val products: List<ProductQuantityData>
)