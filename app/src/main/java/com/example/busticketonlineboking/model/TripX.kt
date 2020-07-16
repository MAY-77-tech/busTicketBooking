package com.example.busticketonlineboking.model

data class TripX(
    val arrival_time: String,
    val car_id: String,
    val class_name: String,
    val created_at: String,
    val departure_time: String,
    val foregin_price: String,
    val id: String,
    val local_price: String,
    val route_id: String,
    val status: String,
    val updated_at: String
)