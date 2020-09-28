package com.dengun.shopify.di.module

import com.dengun.shopify.data.CatalogData
import com.dengun.shopify.data.ProductQuantityData
import com.dengun.shopify.data.local.store.LocalProductQuantityDataStore
import com.dengun.shopify.data.repository.ProductQuantityDataRepository
import com.dengun.shopify.data.store.DataStore
import com.dengun.shopify.domain.repository.ProductQuantityRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ProductQuantityModule {


    @Provides
    @Named("local")
    fun providesLocalDataStore(datastore: LocalProductQuantityDataStore): DataStore<ProductQuantityData> {
        return datastore
    }

    @Provides
    fun providesRepository(
            @Named("local") local: DataStore<ProductQuantityData>
    ): ProductQuantityRepository {
        return ProductQuantityDataRepository(local)
    }
}