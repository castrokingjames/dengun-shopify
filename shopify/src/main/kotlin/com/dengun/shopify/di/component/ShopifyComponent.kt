package com.dengun.shopify.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import com.dengun.shopify.ShopifyApplication
import com.dengun.shopify.di.module.ApplicationModule
import com.dengun.shopify.di.module.ShopifyModule
import com.dengun.shopify.di.scope.ForApplication
import javax.inject.Singleton

@ForApplication
@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ApplicationModule::class,
            ShopifyModule::class
        ]
)
interface ShopifyComponent : AndroidInjector<ShopifyApplication> {

    @Component.Factory
    interface Factory {

        fun create(module: ApplicationModule, @BindsInstance application: Application): ShopifyComponent
    }

    override fun inject(app: ShopifyApplication)
}