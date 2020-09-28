package com.dengun.shopify.data.remote.response

data class CatalogResponse(
        val id: Long,
        val title: String,
        val handle: String,
        val tags: String,
        val vendor: String,
        val images: List<ImageResponse>,
        val variants: List<VariantResponse>
) {

    data class ImageResponse(
            val id: Long,
            val src: String
    )

    data class VariantResponse(
            val id: Long,
            val title: String,
            val price: String,
            val inventory_quantity: Long
    )
}