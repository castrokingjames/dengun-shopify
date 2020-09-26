package @{PACKAGE_NAME}.navigation

import android.app.Activity
import android.os.Bundle
import androidx.navigation.findNavController
import com.airbnb.mvrx.MvRx
import @{PACKAGE_NAME}.R
import @{PACKAGE_NAME}.feature.user.detail.UserDetailArgs
import @{PACKAGE_NAME}.ui.navigation.Navigation

class @{PROJECT_NAME}Navigation(private val activity: Activity) : Navigation {

    override fun navigateToUserDetail(id: Long) {
        val bundle = Bundle()
        bundle.putParcelable(MvRx.KEY_ARG, UserDetailArgs(id))
        val navController = activity.findNavController(R.id.container)
        navController.navigate(R.id.navigate_to_detail, bundle)
    }
}