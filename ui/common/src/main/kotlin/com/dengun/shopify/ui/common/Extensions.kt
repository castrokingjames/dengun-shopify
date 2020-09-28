package com.dengun.shopify.ui.common

import android.widget.ImageView
import com.bumptech.glide.Glide

inline fun ImageView.load(url: CharSequence) = Glide.with(context).load(url).placeholder(R.drawable.ic_baseline_image_24).centerCrop().into(this)