package com.dengun.shopify.domain

data class Catalog(
        val tag: Tag,
        val products: List<ProductQuantity>
)