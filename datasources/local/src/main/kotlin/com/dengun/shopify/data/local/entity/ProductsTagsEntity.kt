package com.dengun.shopify.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Index

/**
 * Object Key: Surrogate (productId, tagCode)
 * Usage: Matching (many-to-many)
 */
@Entity(
        tableName = "ProductsTags",
        primaryKeys = [
            "productId",
            "tagCode"
        ],
        indices = [
            Index(
                    value = [
                        "productId",
                        "tagCode"
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
                    entity = TagEntity::class,
                    parentColumns = ["code"],
                    childColumns = ["tagCode"],
                    onDelete = CASCADE
            )
        ]
)
data class ProductsTagsEntity(
        val productId: Long,
        val tagCode: String
)