package com.example.busticketonlineboking.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.busticketonlineboking.api.Api
import com.example.busticketonlineboking.model.Search
import com.example.busticketonlineboking.model.Trip
import com.example.busticketonlineboking.model.TripInformation
import com.example.busticketonlineboking.model.TripX
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchTripVM:ViewModel(){

    var resultSearchTrip: MutableLiveData<List<TripX>> = MutableLiveData()
    fun getSearchTrip(): LiveData<List<TripX>> = resultSearchTrip

    private val apiSearchTrip = Api()
    fun loadSearch(departure:String,route_Id:Int) {
        val apiCall = apiSearchTrip.getSearchTrip(departure,route_Id)

        apiCall.enqueue(object : Callback<Search> {
            override fun onFailure(call: Call<Search>, t: Throwable) {
                Log.i("Error>>>>>>>", "Loading lhf;lqjerupowijv;ldpqeofpwodhvf;sldokfj")
            }

            override fun onResponse(call: Call<Search>, response: Response<Search>) {
                response.isSuccessful.let {
                    var searchTripList: List<TripX> = response.body()?.trips?: emptyList()
                    Log.e("RESULTTTT",searchTripList.toString())
                    resultSearchTrip.value = searchTripList
                }
            }
        })
    }
}