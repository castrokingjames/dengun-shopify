package com.dengun.shopify.data.local.entity

import androidx.room.Entity
import androidx.room.Index

/**
 * Object Key: Natural (code)
 * Usage: Look-up/Reference
 */
@Entity(
        tableName = "Tag",
        primaryKeys = [
            "code"
        ],
        indices = [
            Index(
                    value = [
                        "code",
                        "name"
                    ]
            )
        ]
)
data class TagEntity(
        val code: String,
        val name: String
)