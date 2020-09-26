package @{PACKAGE_NAME}.feature.user.list.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import @{PACKAGE_NAME}.feature.user.list.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class UserRow @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val nameTextView: TextView

    init {
        inflate(context, R.layout.row_user, this)
        nameTextView = findViewById(R.id.nameTextView)
    }

    @TextProp
    fun setName(name: CharSequence) {
        nameTextView.text = name
    }

    @CallbackProp
    fun setClickListener(clickListener: OnClickListener?) {
        setOnClickListener(clickListener)
    }
}