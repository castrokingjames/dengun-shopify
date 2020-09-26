package @{PACKAGE_NAME}.feature.user.detail

import com.airbnb.mvrx.*
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import @{PACKAGE_NAME}.dispatcher.DispatcherManager
import @{PACKAGE_NAME}.domain.repository.UserRepository
import @{PACKAGE_NAME}.ui.mvrx.MvRxViewModel
import kotlin.coroutines.CoroutineContext

class UserDetailViewModel @AssistedInject constructor(
        @Assisted private val state: UserDetailState,
        private val dispatcherManager: DispatcherManager,
        private val userRepository: UserRepository
) : MvRxViewModel<UserDetailState>(state), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = dispatcherManager.main + job

    init {
        load()
    }

    private fun load() {
        launch(dispatcherManager.io) {
            val user = userRepository.loadById(state.id)
            withContext(dispatcherManager.main) {
                setState {
                    copy(user = user?.let { Success(user) }
                            ?: Fail(NullPointerException("$id not found")))
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
        fun create(state: UserDetailState): UserDetailViewModel
    }

    companion object : MvRxViewModelFactory<UserDetailViewModel, UserDetailState> {
        override fun create(viewModelContext: ViewModelContext, state: UserDetailState): UserDetailViewModel? {
            val fragment: UserDetailFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.viewModelFactory.create(state)
        }
    }
}