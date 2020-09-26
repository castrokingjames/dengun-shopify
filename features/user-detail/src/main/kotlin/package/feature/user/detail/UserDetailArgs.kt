package @{PACKAGE_NAME}.feature.user.detail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserDetailArgs(val id: Long) : Parcelable