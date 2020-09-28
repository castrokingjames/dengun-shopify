package com.dengun.shopify.data.local.entity

import androidx.room.Entity
import androidx.room.Index

/**
 * Object Key: Surrogate (id)
 * Usage: Look-up/Reference
 */
@Entity(
        tableName = "Image",
        primaryKeys = [
            "id"
        ],
        indices = [
            Index(
                    value = [
                        "id"
                    ]
            )
        ]
)
data class ImageEntity(
        val id: Long,
        val url: String
)