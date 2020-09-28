package com.dengun.shopify.data

data class ProductData(
        val id: Long,
        val code: String,
        val name: String,
        val vendor: VendorData,
        val images: List<ImageData>
)