package com.dengun.shopify.data.remote.service

import com.dengun.shopify.data.remote.response.ShopifyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ShopifyService {

    @GET("/admin/products.json")
    suspend fun load(
            @Query("page") page: Int,
            @Query("access_token") accessToken: String
    ): ShopifyResponse
}