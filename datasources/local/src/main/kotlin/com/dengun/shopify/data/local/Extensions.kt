package com.dengun.shopify.data.local

import com.dengun.shopify.data.*
import com.dengun.shopify.data.local.entity.*

inline fun TagEntity.toData() = TagData(code, name)

inline fun TagData.toEntity() = TagEntity(code, name)

inline fun CatalogData.tag() = TagData(tag.code, tag.name)

inline fun ProductData.toEntity() = ProductEntity(id, code, name)

inline fun ProductEntity.toData(vendor: VendorData, images: List<ImageData>) = ProductData(id, code, name, vendor, images)

inline fun VendorData.toEntity() = VendorEntity(code, name)

inline fun VendorEntity.toData() = VendorData(code, name)

inline fun ImageData.toEntity() = ImageEntity(id, url)

inline fun ImageEntity.toData() = ImageData(id, url)

inline fun VariantData.toEntity() = VariantEntity(id, name, price)

inline fun VariantEntity.toData() = VariantData(id, name, price)