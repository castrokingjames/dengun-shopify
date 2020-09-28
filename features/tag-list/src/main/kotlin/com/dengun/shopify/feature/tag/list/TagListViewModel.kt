package com.dengun.shopify.feature.tag.list

import com.airbnb.mvrx.*
import com.dengun.shopify.dispatcher.DispatcherManager
import com.dengun.shopify.domain.repository.CatalogRepository
import com.dengun.shopify.ui.mvrx.MvRxViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

class TagListViewModel @AssistedInject constructor(
        @Assisted private val state: TagListState,
        private val dispatcherManager: DispatcherManager,
        private val catalogRepository: CatalogRepository
) : MvRxViewModel<TagListState>(state), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = dispatcherManager.main + job

    init {
        load()
    }

    private fun load() {
        val context = CoroutineExceptionHandler { _, exception ->
            setState {
                copy(catalogs = Fail(exception))
            }
        } + dispatcherManager.io
        launch(context) {
            catalogRepository
                    .load()
                    .collect { catalogs ->
                        withContext(dispatcherManager.main) {
                            setState {
                                copy(catalogs = Success(catalogs))
                            }
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
        fun create(state: TagListState): TagListViewModel
    }

    companion object : MvRxViewModelFactory<TagListViewModel, TagListState> {
        override fun create(viewModelContext: ViewModelContext, state: TagListState): TagListViewModel? {
            val fragment: TagListFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.viewModelFactory.create(state)
        }
    }
}