package com.example.busticketonlineboking.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CarId(
    val car_image: String,
    val car_no: String,
    val id: Int,
    val seat_no: String,
    val type: String
) : Parcelable