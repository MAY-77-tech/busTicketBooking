package com.example.busticketonlineboking.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class From(
    val city: String
) : Parcelable