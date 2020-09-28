package com.dengun.shopify.di.module

import com.dengun.shopify.data.CatalogData
import com.dengun.shopify.data.local.store.LocalCatalogDataStore
import com.dengun.shopify.data.remote.store.RemoteCatalogDataStore
import com.dengun.shopify.data.repository.CatalogDataRepository
import com.dengun.shopify.data.store.DataStore
import com.dengun.shopify.domain.repository.CatalogRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class CatalogModule {

    @Provides
    @Named("remote")
    fun providesRemoteDataStore(datastore: RemoteCatalogDataStore): DataStore<CatalogData> {
        return datastore
    }

    @Provides
    @Named("local")
    fun providesLocalDataStore(datastore: LocalCatalogDataStore): DataStore<CatalogData> {
        return datastore
    }

    @Provides
    fun providesRepository(
            @Named("remote") remote: DataStore<CatalogData>,
            @Named("local") local: DataStore<CatalogData>
    ): CatalogRepository {
        return CatalogDataRepository(remote, local)
    }
}