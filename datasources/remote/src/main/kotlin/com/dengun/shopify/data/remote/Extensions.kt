package com.dengun.shopify.data.remote

import com.dengun.shopify.data.*
import com.dengun.shopify.data.remote.response.CatalogResponse

inline fun CatalogResponse.product() = ProductData(id, handle, title, vendor(), images())

inline fun CatalogResponse.productQuantityData() = ProductQuantityData(product(), variant())

inline fun CatalogResponse.vendor() = VendorData(vendor.id(), vendor)

inline fun CatalogResponse.images() = images.map { image -> image.toData() }

inline fun CatalogResponse.tags() = tags.split(",").map { tag -> TagData(tag.trim().id(), tag.trim()) }

inline fun CatalogResponse.ImageResponse.toData() = ImageData(id, src)

inline fun CatalogResponse.variant() = variants.map { variant -> variant.toData() to variant.inventory_quantity }.toMap()

inline fun CatalogResponse.VariantResponse.toData() = VariantData(id, title, price)

inline fun String.id() = replace(Regex("[^A-Za-z0-9 -]"), "").replace(" ", "-").toLowerCase()