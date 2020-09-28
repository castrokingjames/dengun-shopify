package com.dengun.shopify.di.component

import com.dengun.shopify.RootActivity
import com.dengun.shopify.di.module.*
import com.dengun.shopify.di.scope.ForActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ForActivity
@Subcomponent(
        modules = [
            RootModule::class,
            DispatcherModule::class,
            NavigationModule::class,
            ConfigModule::class,
            WebserviceModule::class,
            DatabaseModule::class,
            CatalogModule::class,
            ProductQuantityModule::class
        ]
)
interface RootSubComponent : AndroidInjector<RootActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<RootActivity>
}