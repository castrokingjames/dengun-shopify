package com.dengun.shopify.feature.product.list

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductListArgs(val code: String, val name: String) : Parcelable