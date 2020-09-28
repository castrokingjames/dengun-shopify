package com.dengun.shopify.feature.tag.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.fragmentViewModel
import com.dengun.shopify.domain.Tag
import com.dengun.shopify.feature.tag.list.views.tagRow
import com.dengun.shopify.ui.mvrx.MvRxFragment
import com.dengun.shopify.ui.mvrx.simpleController
import com.dengun.shopify.ui.navigation.Navigation
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class TagListFragment : MvRxFragment() {

    @Inject
    lateinit var viewModelFactory: TagListViewModel.Factory

    @Inject
    lateinit var navigation: Navigation

    private val viewModel: TagListViewModel by fragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.title = getString(R.string.app_name)
    }

    override fun epoxyController() = simpleController(viewModel) { state ->
        when (val catalogs = state.catalogs) {
            is Success -> {
                catalogs
                        .invoke()
                        .forEach { catalog ->
                            val tag = catalog.tag
                            tagRow {
                                id(tag.code)
                                name(tag.name)
                                clickListener { _ ->
                                    onTagClick(tag)
                                }
                            }
                        }
            }
            is Fail -> {
                val context = requireContext()
                val error = catalogs.error
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onTagClick(tag: Tag) {
        navigation.navigateToProductList(tag.code, tag.name)
    }
}