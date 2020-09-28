package com.dengun.shopify.data.repository

import com.dengun.shopify.data.store.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class NetworkBoundResourceDataRepository<D, T>(
        private val remote: DataStore<D>,
        private val local: DataStore<D>
) : DataRepository<D, T> {

    override suspend fun load(): Flow<List<T>> {
        return flow {
            loadFromLocal()
                    .ifEmpty {
                        loadFromNetwork()
                                .apply {
                                    saveToLocal(this)
                                }
                        loadFromLocal()
                    }
                    .map { data ->
                        toDomain(data)
                    }
                    .apply {
                        emit(this)
                        loadFromNetwork()
                                .apply {
                                    saveToLocal(this)
                                }
                        loadFromLocal()
                                .map { data ->
                                    toDomain(data)
                                }
                                .apply {
                                    emit(this)
                                }
                    }
        }
    }

    override suspend fun loadById(id: Any): List<T> {
        var list = local.loadById(id)
        if (list.isEmpty()) {
            list = remote.loadById(id)
        }
        return list.map { data -> toDomain(data) }
    }

    private suspend fun loadFromNetwork(): List<D> {
        return try {
            remote.load()
        } catch (exception: Exception) {
            throw exception
        }
    }

    private suspend fun loadFromLocal(): List<D> {
        return local.load()
    }

    private suspend fun saveToLocal(data: List<D>) {
        local.save(data)
    }
}