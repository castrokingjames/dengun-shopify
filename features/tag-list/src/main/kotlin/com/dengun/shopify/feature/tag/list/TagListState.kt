package com.dengun.shopify.feature.tag.list

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.dengun.shopify.domain.Catalog

data class TagListState(val catalogs: Async<List<Catalog>> = Uninitialized) : MvRxState