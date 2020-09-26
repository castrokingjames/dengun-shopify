package @{PACKAGE_NAME}.feature.user.list

import com.airbnb.mvrx.*
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import @{PACKAGE_NAME}.dispatcher.DispatcherManager
import @{PACKAGE_NAME}.domain.repository.UserRepository
import @{PACKAGE_NAME}.ui.mvrx.MvRxViewModel
import kotlin.coroutines.CoroutineContext

class UserListViewModel @AssistedInject constructor(
        @Assisted private val state: UserListState,
        private val dispatcherManager: DispatcherManager,
        private val userRepository: UserRepository
) : MvRxViewModel<UserListState>(state), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = dispatcherManager.main + job

    init {
        load()
    }

    private fun load() {
        val context = CoroutineExceptionHandler { _, exception ->
            setState {
                copy(users = Fail(exception))
            }
        } + dispatcherManager.io
        launch(context) {
            userRepository
                    .load()
                    .collect { users ->
                        withContext(dispatcherManager.main) {
                            setState {
                                copy(users = Success(users))
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
        fun create(state: UserListState): UserListViewModel
    }

    companion object : MvRxViewModelFactory<UserListViewModel, UserListState> {
        override fun create(viewModelContext: ViewModelContext, state: UserListState): UserListViewModel? {
            val fragment: UserListFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.viewModelFactory.create(state)
        }
    }
}