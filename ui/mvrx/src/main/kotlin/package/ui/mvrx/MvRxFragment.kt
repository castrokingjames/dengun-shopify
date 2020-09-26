package @{PACKAGE_NAME}.ui.mvrx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.airbnb.mvrx.BaseMvRxFragment
import kotlinx.android.synthetic.main.fragment_mvrx.*

abstract class MvRxFragment : BaseMvRxFragment() {

    private val epoxyController by lazy { epoxyController() }

    val toolbar: Toolbar get() = mvrxToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        epoxyController.onRestoreInstanceState(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mvrx, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navController = findNavController(this)
        toolbar.setupWithNavController(navController)
        epoxyRecyclerView.setController(epoxyController)
    }

    override fun invalidate() {
        epoxyRecyclerView.requestModelBuild()
    }

    /**
     * Provide the EpoxyController to use when building models for this Fragment.
     * Basic usages can simply use [simpleController]
     */
    abstract fun epoxyController(): MvRxEpoxyController

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        epoxyController.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        epoxyController.cancelPendingModelBuild()
        super.onDestroyView()
    }
}