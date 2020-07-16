package com.example.busticketonlineboking.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.busticketonlineboking.api.Api
import com.example.busticketonlineboking.model.City
import com.example.busticketonlineboking.model.Trip
import com.example.busticketonlineboking.model.TripInformation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TripViewModel:ViewModel(){
    var resultSearchTrip: MutableLiveData<List<Trip>> = MutableLiveData()
    fun getSearchTrip(): LiveData<List<Trip>> = resultSearchTrip

    private val apiSearchTrip = Api()
    fun loadSearch(departure:String,route_Id:String) {
        val apiCall = apiSearchTrip.getSearchTrip(departure,route_Id)

        apiCall.enqueue(object : Callback<TripInformation> {
            override fun onFailure(call: Call<TripInformation>, t: Throwable) {
                Log.i("Error>>>>>>>", "Loading Fail")
            }

            override fun onResponse(call: Call<TripInformation>, response: Response<TripInformation>) {
                response.isSuccessful.let {
                    var searchTripList: List<Trip> = response.body()?.trips?: emptyList()
                    resultSearchTrip.value = searchTripList
                }
            }
        })
    }
}