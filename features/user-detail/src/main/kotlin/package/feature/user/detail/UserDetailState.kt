package @{PACKAGE_NAME}.feature.user.detail

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import @{PACKAGE_NAME}.domain.User

data class UserDetailState(val id: Long, val user: Async<User> = Uninitialized) : MvRxState {
    constructor(args: UserDetailArgs) : this(id = args.id)
}