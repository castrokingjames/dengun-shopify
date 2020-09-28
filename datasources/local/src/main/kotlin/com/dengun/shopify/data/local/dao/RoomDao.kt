package com.dengun.shopify.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface RoomDao<E> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: E)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entities: List<E>)
}