package com.dengun.shopify.di.module

import dagger.Module
import dagger.Provides
import com.dengun.shopify.di.scope.ForActivity
import com.dengun.shopify.dispatcher.DispatcherManager
import com.dengun.shopify.manager.dispatcher.AndroidDispatcherManager

@Module
class DispatcherModule {

    @Provides
    @ForActivity
    fun providesDispatcher(): DispatcherManager {
        return AndroidDispatcherManager()
    }
}