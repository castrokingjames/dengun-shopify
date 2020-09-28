package com.dengun.shopify.domain

data class ProductQuantity(val product: Product, val variant: Map<Variant, Long>) {

    val quantity: Long get() = variant.map { variant -> variant.value }.toList().sum()

}