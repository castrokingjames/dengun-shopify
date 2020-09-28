package com.dengun.shopify.feature.product.list

import com.airbnb.mvrx.*
import com.dengun.shopify.dispatcher.DispatcherManager
import com.dengun.shopify.domain.repository.ProductQuantityRepository
import com.dengun.shopify.ui.mvrx.MvRxViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ProductListViewModel @AssistedInject constructor(
        @Assisted private val state: ProductListState,
        private val dispatcherManager: DispatcherManager,
        private val productQuantityRepository: ProductQuantityRepository
) : MvRxViewModel<ProductListState>(state), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = dispatcherManager.main + job

    init {
        load()
    }

    private fun load() {
        val context = CoroutineExceptionHandler { _, exception ->
            setState {
                copy(products = Fail(exception))
            }
        } + dispatcherManager.io
        launch(context) {
            val products = productQuantityRepository.loadById(state.tag.code)
            withContext(dispatcherManager.main) {
                setState {
                    copy(products = Success(products))
                }
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: ProductListState): ProductListViewModel
    }

    companion object : MvRxViewModelFactory<ProductListViewModel, ProductListState> {
        override fun create(viewModelContext: ViewModelContext, state: ProductListState): ProductListViewModel? {
            val fragment: ProductListFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.viewModelFactory.create(state)
        }
    }
}