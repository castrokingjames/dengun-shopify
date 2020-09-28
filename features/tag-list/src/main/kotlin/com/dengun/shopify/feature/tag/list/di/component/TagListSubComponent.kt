package com.dengun.shopify.feature.tag.list.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import com.dengun.shopify.di.scope.ForFragment
import com.dengun.shopify.feature.tag.list.TagListFragment
import com.dengun.shopify.feature.tag.list.di.module.AssistedModule

@ForFragment
@Subcomponent(
        modules = [
            AssistedModule::class
        ]
)
interface TagListSubComponent : AndroidInjector<TagListFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<TagListFragment>
}