package com.dengun.shopify.di.module

import com.dengun.shopify.data.remote.manager.RetrofitServiceManager
import com.dengun.shopify.data.remote.manager.ServiceManager
import com.dengun.shopify.data.remote.service.ShopifyService
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class WebserviceModule {

    @Provides
    fun providesServiceManager(@Named("SHOPIFY_BASE_URL") shopifyBaseURL: String): ServiceManager {
        return RetrofitServiceManager(shopifyBaseURL)
    }

    @Provides
    fun providesShopifyService(serviceManager: ServiceManager): ShopifyService {
        return serviceManager.shopifyService()
    }
}