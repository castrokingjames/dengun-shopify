package com.dengun.shopify.data.repository

import com.dengun.shopify.domain.repository.Repository

interface DataRepository<D, T> : Repository<T> {

    fun toDomain(data: D): T
}