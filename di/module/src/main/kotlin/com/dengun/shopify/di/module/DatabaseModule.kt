package com.dengun.shopify.di.module

import android.content.Context
import com.dengun.shopify.data.local.dao.*
import com.dengun.shopify.data.local.manager.DatabaseManager
import com.dengun.shopify.data.local.manager.RoomDatabaseManager
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun providesDatabaseManager(context: Context): DatabaseManager {
        return RoomDatabaseManager.create(context)
    }

    @Provides
    fun providesImageDao(databaseManager: DatabaseManager): ImageDao {
        return databaseManager.imageDao()
    }

    @Provides
    fun providesProductDao(databaseManager: DatabaseManager): ProductDao {
        return databaseManager.productDao()
    }

    @Provides
    fun providesProductImagesDao(databaseManager: DatabaseManager): ProductImagesDao {
        return databaseManager.productImagesDao()
    }

    @Provides
    fun providesProductQuantityDao(databaseManager: DatabaseManager): ProductQuantityDao {
        return databaseManager.productQuantityDao()
    }

    @Provides
    fun providesProductsTagsDao(databaseManager: DatabaseManager): ProductsTagsDao {
        return databaseManager.productsTagsDao()
    }

    @Provides
    fun providesProductVariantsDao(databaseManager: DatabaseManager): ProductVariantsDao {
        return databaseManager.productVariantsDao()
    }

    @Provides
    fun providesProductVendorDao(databaseManager: DatabaseManager): ProductVendorDao {
        return databaseManager.productVendorDao()
    }

    @Provides
    fun providesTagDao(databaseManager: DatabaseManager): TagDao {
        return databaseManager.tagDao()
    }

    @Provides
    fun providesVariantDao(databaseManager: DatabaseManager): VariantDao {
        return databaseManager.variantDao()
    }

    @Provides
    fun providesVendorDao(databaseManager: DatabaseManager): VendorDao {
        return databaseManager.vendorDao()
    }
}