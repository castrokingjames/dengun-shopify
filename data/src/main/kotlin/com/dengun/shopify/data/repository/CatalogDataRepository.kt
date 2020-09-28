package com.dengun.shopify.data.repository

import com.dengun.shopify.data.CatalogData
import com.dengun.shopify.data.store.DataStore
import com.dengun.shopify.data.toDomain
import com.dengun.shopify.domain.Catalog
import com.dengun.shopify.domain.repository.CatalogRepository

class CatalogDataRepository(
        val remote: DataStore<CatalogData>,
        val local: DataStore<CatalogData>
) : NetworkBoundResourceDataRepository<CatalogData, Catalog>(remote, local), CatalogRepository {

    override fun toDomain(data: CatalogData): Catalog {
        return data.toDomain()
    }
}