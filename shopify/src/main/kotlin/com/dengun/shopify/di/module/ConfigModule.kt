package com.dengun.shopify.di.module

import com.dengun.shopify.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ConfigModule {

    @Provides
    @Named("SHOPIFY_API_KEY")
    fun providesShopifyApiKey(): String {
        return BuildConfig.SHOPIFY_API_KEY
    }

    @Provides
    @Named("SHOPIFY_BASE_URL")
    fun providesShopifyBaseURL(): String {
        return BuildConfig.SHOPIFY_BASE_URL
    }
}