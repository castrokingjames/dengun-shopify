package com.dengun.shopify.data

import com.dengun.shopify.domain.*

inline fun VendorData.toDomain() = Vendor(code, name)

inline fun ImageData.toDomain() = Image(id, url)

inline fun VariantData.toDomain() = Variant(id, name)

inline fun ProductData.toDomain() = Product(id, code, name, vendor.toDomain(), images.map { image -> image.toDomain() })

inline fun ProductQuantityData.toDomain() = ProductQuantity(product.toDomain(), variant.map { (key, value) -> key.toDomain() to value }.toMap())

inline fun TagData.toDomain() = Tag(code, name)

inline fun CatalogData.toDomain() = Catalog(tag.toDomain(), products.map { product -> product.toDomain() })