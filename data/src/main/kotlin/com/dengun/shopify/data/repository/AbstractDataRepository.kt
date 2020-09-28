package com.dengun.shopify.data.repository

import com.dengun.shopify.data.store.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class AbstractDataRepository<D, T>(private val datastore: DataStore<D>) : DataRepository<D, T> {

    override suspend fun load(): Flow<List<T>> {
        return flow {
            datastore
                    .load()
                    .map { data ->
                        toDomain(data)
                    }
                    .apply {
                        emit(this)
                    }
        }
    }

    override suspend fun loadById(id: Any): List<T> {
        return datastore.loadById(id).map { data -> toDomain(data) }
    }
}