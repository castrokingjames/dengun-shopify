package com.dengun.shopify.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index


/**
 * Object Key: Surrogate (variantId)
 * Usage: Pivot/Match
 */
@Entity(
        tableName = "ProductQuantity",
        primaryKeys = [
            "variantId"
        ],
        indices = [
            Index(
                    value = [
                        "variantId"
                    ]
            )
        ],
        foreignKeys = [
            ForeignKey(
                    entity = VariantEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["variantId"],
                    onDelete = ForeignKey.CASCADE
            )
        ]
)
data class ProductQuantityEntity(
        val variantId: Long,
        val quantity: Long
)