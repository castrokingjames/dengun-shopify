package com.dengun.shopify.di.module

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import com.dengun.shopify.RootActivity
import com.dengun.shopify.di.component.RootSubComponent

@Module(
        subcomponents = [
            RootSubComponent::class
        ]
)
abstract class ShopifyModule {

    @Binds
    @IntoMap
    @ClassKey(RootActivity::class)
    abstract fun bindRootActivityInjectorFactory(factory: RootSubComponent.Factory): AndroidInjector.Factory<*>
}