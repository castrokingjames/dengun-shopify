package com.dengun.shopify.data.local.entity

import androidx.room.Entity
import androidx.room.Index

/**
 * Object Key: Natural (code)
 * Usage: Look-up/Reference
 */
@Entity(
        tableName = "Vendor",
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
data class VendorEntity(
        val code: String,
        val name: String
)