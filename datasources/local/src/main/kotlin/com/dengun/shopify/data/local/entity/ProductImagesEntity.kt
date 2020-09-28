package com.dengun.shopify.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

/**
 * Object Key: Surrogate (productId, imageId)
 * Usage: Matching (one-to-many)
 */
@Entity(
        tableName = "ProductImages",
        primaryKeys = [
            "productId",
            "imageId"
        ],
        indices = [
            Index(
                    value = [
                        "productId",
                        "imageId"
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
                    entity = ImageEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["imageId"],
                    onDelete = ForeignKey.CASCADE
            )
        ]
)
data class ProductImagesEntity(
        val productId: Long,
        val imageId: Long
)