package com.example.busticketonlineboking.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.busticketonlineboking.api.Api
import com.example.busticketonlineboking.model.City
import com.example.busticketonlineboking.model.Route
import com.example.busticketonlineboking.model.RouteId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RouteViewModel : ViewModel() {
    private var route: MutableLiveData<List<RouteId>> = MutableLiveData()
    fun getRoute(): MutableLiveData<List<RouteId>> = route

    val api: Api = Api()
    fun loadRoute() {
        val apiCall = api.getRoute()

        apiCall.enqueue(object : Callback<Route> {
            override fun onFailure(call: Call<Route>, t: Throwable) {
                Log.d("Result Error>>>>>", t.toString())
            }

            override fun onResponse(call: Call<Route>, response: Response<Route>) {
                response.isSuccessful.let {
                    val routeResult = response.body()?.routes
                    route.value = routeResult ?: emptyList()
                }
            }
        })
    }
}