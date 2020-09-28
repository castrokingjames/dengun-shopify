package com.dengun.shopify.data.remote.manager

import com.dengun.shopify.data.remote.service.ShopifyService

interface ServiceManager {

    fun shopifyService(): ShopifyService
}