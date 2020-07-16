package com.example.busticketonlineboking.api

import com.example.busticketonlineboking.model.City
import com.example.busticketonlineboking.model.TripInformation
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api{
    private val cityApiInterface : CityApiInterface

companion object{
    const val BASE_URL = "https://carticket.khaingthinkyi.me/api/"
}

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        cityApiInterface = retrofit.create(CityApiInterface::class.java)
    }

    fun getCity(): Call<City>{
        return cityApiInterface.getCity()
    }

    fun getTripInformation(): Call<TripInformation>{
        return cityApiInterface.getTrip()
    }

    fun getSearchTrip(deaparture_time:String,route_Id: String): Call<TripInformation>{
        return cityApiInterface.getSearchTrip(deaparture_time,route_Id)
    }
}