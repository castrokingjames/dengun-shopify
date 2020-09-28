package com.dengun.shopify.di.module

import android.app.Activity
import com.dengun.shopify.RootActivity
import com.dengun.shopify.feature.product.list.ProductListFragment
import com.dengun.shopify.feature.product.list.di.component.ProductListSubComponent
import com.dengun.shopify.feature.tag.list.TagListFragment
import com.dengun.shopify.feature.tag.list.di.component.TagListSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
        subcomponents = [
            TagListSubComponent::class,
            ProductListSubComponent::class
        ]
)
abstract class RootModule {

    @Binds
    @IntoMap
    @ClassKey(TagListFragment::class)
    abstract fun bindTagListSubComponentFactory(factory: TagListSubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(ProductListFragment::class)
    abstract fun bindProductListSubComponentFactory(factory: ProductListSubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    abstract fun bindActivity(factory: RootActivity): Activity
}