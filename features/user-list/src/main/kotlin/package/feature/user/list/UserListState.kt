package @{PACKAGE_NAME}.feature.user.list

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import @{PACKAGE_NAME}.domain.User

data class UserListState(val users: Async<List<User>> = Uninitialized) : MvRxState