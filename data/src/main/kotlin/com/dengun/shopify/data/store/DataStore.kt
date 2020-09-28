package com.dengun.shopify.data.store

interface DataStore<T> {

    suspend fun load(): List<T>

    suspend fun save(data: List<T>)

    suspend fun loadById(id: Any): List<T>
}