package com.dengun.shopify.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

/**
 * Object Key: Surrogate (productId, vendorCode)
 * Usage: Matching (one-to-one)
 */
@Entity(
        tableName = "ProductVendor",
        primaryKeys = [
            "productId"
        ],
        indices = [
            Index(
                    value = [
                        "productId",
                        "vendorCode"
                    ]
            )
        ],
        foreignKeys = [
            ForeignKey(
                    entity = ProductEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["productId"],
                    onDelete = ForeignKey.CASCADE
            ),
            ForeignKey(
                    entity = VendorEntity::class,
                    parentColumns = ["code"],
                    childColumns = ["vendorCode"],
                    onDelete = ForeignKey.CASCADE
            )
        ]
)
data class ProductVendorEntity(
        val productId: Long,
        val vendorCode: String
)