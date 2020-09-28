package com.dengun.shopify.navigation

import android.app.Activity
import android.os.Bundle
import androidx.navigation.findNavController
import com.airbnb.mvrx.MvRx
import com.dengun.shopify.R
import com.dengun.shopify.feature.product.list.ProductListArgs
import com.dengun.shopify.ui.navigation.Navigation

class ShopifyNavigation(private val activity: Activity) : Navigation {

    override fun navigateToProductList(code: String, name: String) {
        val bundle = Bundle()
        bundle.putParcelable(MvRx.KEY_ARG, ProductListArgs(code, name))
        val navController = activity.findNavController(R.id.container)
        navController.navigate(R.id.navigate_to_product_list, bundle)
    }
}