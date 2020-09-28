package com.dengun.shopify.data

data class ProductQuantityData(val product: ProductData, val variant: Map<VariantData, Long>) {

    val quantity: Long get() = variant.map { variant -> variant.value }.toList().sum()

}