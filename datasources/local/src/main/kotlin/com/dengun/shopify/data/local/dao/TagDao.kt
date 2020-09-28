package com.dengun.shopify.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.dengun.shopify.data.local.entity.TagEntity

@Dao
interface TagDao : RoomDao<TagEntity> {

    @Query("SELECT * FROM Tag ORDER BY name ASC")
    suspend fun select(): List<TagEntity>

    @Query("SELECT * FROM Tag WHERE code = :code")
    suspend fun selectById(code: String): TagEntity
}