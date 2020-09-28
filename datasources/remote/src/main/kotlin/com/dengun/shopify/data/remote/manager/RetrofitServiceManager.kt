package com.dengun.shopify.data.remote.manager

import com.dengun.shopify.data.remote.service.ShopifyService
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitServiceManager(val baseUrl: String) : ServiceManager {

    private var retrofit: Retrofit

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl("https://shopicruit.myshopify.com")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(client)
                .build()
    }


    override fun shopifyService(): ShopifyService {
        return retrofit.create(ShopifyService::class.java)
    }
}