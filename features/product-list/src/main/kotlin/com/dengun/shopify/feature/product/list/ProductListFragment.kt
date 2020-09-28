package com.dengun.shopify.feature.product.list

import android.os.Bundle
import android.widget.Toast
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.dengun.shopify.domain.Product
import com.dengun.shopify.feature.product.list.views.productRow
import com.dengun.shopify.ui.mvrx.MvRxFragment
import com.dengun.shopify.ui.mvrx.simpleController
import com.dengun.shopify.ui.navigation.Navigation
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ProductListFragment : MvRxFragment() {

    @Inject
    lateinit var viewModelFactory: ProductListViewModel.Factory

    @Inject
    lateinit var navigation: Navigation

    private val viewModel: ProductListViewModel by fragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun invalidate() {
        super.invalidate()
        withState(viewModel) { state ->
            toolbar.title = state.tag.name
        }
    }

    override fun epoxyController() = simpleController(viewModel) { state ->
        when (val products = state.products) {
            is Success -> {
                products
                        .invoke()
                        .forEach { product ->
                            productRow {
                                id(product.product.id)
                                productName(product.product.name)
                                vendorName(product.product.vendor.name)
                                quantity("${product.quantity}")
                                imageUrl(product.product.images.random().url)
                                clickListener { _ ->
                                    onProductClick(product.product)
                                }
                            }
                        }
            }
            is Fail -> {
                val context = requireContext()
                val error = products.error
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onProductClick(product: Product) {
    }
}