package com.dengun.shopify.feature.product.list

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.dengun.shopify.domain.ProductQuantity
import com.dengun.shopify.domain.Tag

data class ProductListState(val tag: Tag, val products: Async<List<ProductQuantity>> = Uninitialized) : MvRxState {
    constructor(args: ProductListArgs) : this(tag = Tag(args.code, args.name))
}