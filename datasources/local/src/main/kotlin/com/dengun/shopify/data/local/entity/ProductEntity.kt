package com.dengun.shopify.data.local.entity

import androidx.room.Entity
import androidx.room.Index

/**
 * Object Key: Surrogate (id), Natural (code)
 * Usage: Look-up/Reference
 */
@Entity(
        tableName = "Product",
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
data class ProductEntity(
        val id: Long,
        val code: String,
        val name: String
)