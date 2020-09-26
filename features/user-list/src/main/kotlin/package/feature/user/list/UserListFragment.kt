package @{PACKAGE_NAME}.feature.user.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.fragmentViewModel
import dagger.android.support.AndroidSupportInjection
import @{PACKAGE_NAME}.domain.User
import @{PACKAGE_NAME}.feature.user.list.views.userRow
import @{PACKAGE_NAME}.ui.mvrx.MvRxFragment
import @{PACKAGE_NAME}.ui.mvrx.simpleController
import @{PACKAGE_NAME}.ui.navigation.Navigation
import javax.inject.Inject

class UserListFragment : MvRxFragment() {

    @Inject
    lateinit var viewModelFactory: UserListViewModel.Factory

    @Inject
    lateinit var navigation: Navigation

    private val viewModel: UserListViewModel by fragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.title = "Users"
    }

    override fun epoxyController() = simpleController(viewModel) { state ->
        when (val users = state.users) {
            is Success -> {
                users
                        .invoke()
                        .forEach { user ->
                            userRow {
                                id(user.id)
                                name(user.name)
                                clickListener { _ ->
                                    onUserClick(user)
                                }
                            }
                        }
            }
            is Fail -> {
                val context = requireContext()
                val error = users.error
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onUserClick(user: User) {
        navigation.navigateToUserDetail(user.id)
    }
}