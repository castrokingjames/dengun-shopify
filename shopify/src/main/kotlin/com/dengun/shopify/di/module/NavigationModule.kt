package com.dengun.shopify.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import com.dengun.shopify.navigation.ShopifyNavigation
import com.dengun.shopify.ui.navigation.Navigation

@Module
class NavigationModule {

    @Provides
    fun providesNavigation(activity: Activity): Navigation {
        return ShopifyNavigation(activity)
    }
}