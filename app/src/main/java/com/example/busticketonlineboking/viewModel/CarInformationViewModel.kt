package com.example.busticketonlineboking.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.busticketonlineboking.api.Api
import com.example.busticketonlineboking.model.Trip
import com.example.busticketonlineboking.model.TripInformation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarInformationViewModel :ViewModel(){
     var tripInformation: MutableLiveData<List<Trip>> = MutableLiveData()
    fun getCarInformation(): MutableLiveData<List<Trip>> = tripInformation

    val api: Api = Api()
    fun loadTrip(){
        val apiCall = api.getTripInformation()

        apiCall.enqueue(object : Callback<TripInformation> {
            override fun onFailure(call: Call<TripInformation>, t: Throwable) {
            }

            override fun onResponse(call: Call<TripInformation>,response: Response<TripInformation>) {
                response.isSuccessful?.let {
                    var tripResult:List<Trip> = response.body()?.trips?: emptyList()
                    tripInformation.value = tripResult
                    Log.d("TripResult>>>>",tripResult.toString())
                }
            }
        })
    }
}