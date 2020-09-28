package com.dengun.shopify.data.local.entity

import androidx.room.Entity
import androidx.room.Index

/**
 * Object Key: Surrogate (id)
 * Usage: Look-up/Reference
 */
@Entity(
        tableName = "Variant",
        primaryKeys = [
            "id"
        ],
        indices = [
            Index(
                    value = [
                        "id",
                        "name"
                    ]
            )
        ]
)
data class VariantEntity(
        val id: Long,
        val name: String,
        val price: String
)