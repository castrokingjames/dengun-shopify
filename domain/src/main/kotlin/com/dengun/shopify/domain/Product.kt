package com.dengun.shopify.domain

data class Product(
        val id: Long,
        val code: String,
        val name: String,
        val vendor: Vendor,
        val images: List<Image>
)