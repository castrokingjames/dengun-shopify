package com.dengun.shopify.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Index

/**
 * Object Key: Surrogate (productId, variantId)
 * Usage: Matching (one-to-many)
 */
@Entity(
        tableName = "ProductVariants",
        primaryKeys = [
            "productId",
            "variantId"
        ],
        indices = [
            Index(
                    value = [
                        "productId",
                        "variantId"
                    ]
            )
        ],
        foreignKeys = [
            ForeignKey(
                    entity = ProductEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["productId"],
                    onDelete = CASCADE
            ),
            ForeignKey(
                    entity = VariantEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["variantId"],
                    onDelete = CASCADE
            )
        ]
)
data class ProductVariantsEntity(
        val productId: Long,
        val variantId: Long
)