package @{PACKAGE_NAME}.feature.user.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.airbnb.mvrx.*
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_user_detail.*
import javax.inject.Inject

class UserDetailFragment : BaseMvRxFragment() {

    @Inject
    lateinit var viewModelFactory: UserDetailViewModel.Factory

    private val viewModel: UserDetailViewModel by fragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = NavHostFragment.findNavController(this)
        toolbar.setupWithNavController(navController)
        toolbar.title = getString(R.string.user)
    }

    override fun invalidate() {
        withState(viewModel) { state ->
            when (val user = state.user) {
                is Success -> {
                    val user = user.invoke()
                    toolbar.title = user.name
                    messageTextView.text = getString(R.string.hello_user, user.name)
                }
                is Fail -> {
                    messageTextView.text = user.error.message
                }
            }
        }
    }
}
