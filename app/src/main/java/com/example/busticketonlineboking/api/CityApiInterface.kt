package com.example.busticketonlineboking.api

import com.example.busticketonlineboking.model.*
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
        @Query("route")route_id: Int
    ): Call<Search>

    @GET("route")
    fun  getRoute(): Call<Route>
}