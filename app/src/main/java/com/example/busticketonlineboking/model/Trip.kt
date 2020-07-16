package com.example.busticketonlineboking.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Trip(
    val arrival_time: String,
    val car_id: CarId,
    val class_name: String,
    val departure_time: String,
    val foregin_price: String,
    val id: Int,
    val local_price: String,
    val route_id: RouteId
) : Parcelable