package com.dengun.shopify.data.local.manager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dengun.shopify.data.local.converter.DateTypeConverter
import com.dengun.shopify.data.local.entity.*

@Database(
        entities = [
            ImageEntity::class,
            ProductEntity::class,
            ProductImagesEntity::class,
            ProductQuantityEntity::class,
            ProductsTagsEntity::class,
            ProductVariantsEntity::class,
            ProductVendorEntity::class,
            TagEntity::class,
            VariantEntity::class,
            VendorEntity::class
        ],
        version = 1,
        exportSchema = false
)
@TypeConverters(
        DateTypeConverter::class
)
abstract class RoomDatabaseManager : RoomDatabase(), DatabaseManager {

    companion object {

        fun create(context: Context): DatabaseManager {
            return Room
                    .databaseBuilder(context, RoomDatabaseManager::class.java, "shopify")
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }
}