package com.dengun.shopify.feature.product.list.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.dengun.shopify.feature.product.list.R
import com.dengun.shopify.ui.common.load

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class ProductRow @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val iconImageView: ImageView
    private val productNameTextView: TextView
    private val vendorNameTextView: TextView
    private val quantityTextView: TextView

    init {
        inflate(context, R.layout.row_product, this)
        iconImageView = findViewById(R.id.iconImageView)
        productNameTextView = findViewById(R.id.productNameTextView)
        vendorNameTextView = findViewById(R.id.vendorNameTextView)
        quantityTextView = findViewById(R.id.quantityTextView)
    }

    @TextProp
    fun setProductName(name: CharSequence) {
        productNameTextView.text = name
    }

    @TextProp
    fun setVendorName(name: CharSequence) {
        vendorNameTextView.text = name
    }

    @TextProp
    fun setQuantity(quantity: CharSequence) {
        quantityTextView.text = quantity
    }

    @TextProp
    fun setImageUrl(url: CharSequence) {
        iconImageView.load(url)
    }

    @CallbackProp
    fun setClickListener(clickListener: OnClickListener?) {
        setOnClickListener(clickListener)
    }
}