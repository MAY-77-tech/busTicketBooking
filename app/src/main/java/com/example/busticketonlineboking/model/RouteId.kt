package com.example.busticketonlineboking.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RouteId(
    val from: From,
    val id: Int,
    val to: To
) : Parcelable