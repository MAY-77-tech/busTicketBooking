package com.example.busticketonlineboking.api

import com.example.busticketonlineboking.model.City
import com.example.busticketonlineboking.model.TripInformation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CityApiInterface {

    @GET("location")
    fun getCity(): Call<City>

    @GET("trip")
    fun getTrip(): Call<TripInformation>

    @POST("searchTrip")
    fun getSearchTrip(
        @Query("departure_time")deaparture_time:String,
        @Query("route_id")route_id: String
    ): Call<TripInformation>
}