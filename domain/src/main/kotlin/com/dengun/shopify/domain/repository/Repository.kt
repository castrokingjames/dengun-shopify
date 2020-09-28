package com.dengun.shopify.domain.repository

import kotlinx.coroutines.flow.Flow

interface Repository<T> {

    suspend fun load(): Flow<List<T>>

    suspend fun loadById(id: Any): List<T>
}