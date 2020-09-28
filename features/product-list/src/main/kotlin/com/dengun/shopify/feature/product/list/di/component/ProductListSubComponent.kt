package com.dengun.shopify.feature.product.list.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import com.dengun.shopify.di.scope.ForFragment
import com.dengun.shopify.feature.product.list.ProductListFragment
import com.dengun.shopify.feature.product.list.di.module.AssistedModule

@ForFragment
@Subcomponent(
        modules = [
            AssistedModule::class
        ]
)
interface ProductListSubComponent : AndroidInjector<ProductListFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ProductListFragment>
}