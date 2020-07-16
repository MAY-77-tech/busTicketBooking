package com.example.busticketonlineboking.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.busticketonlineboking.api.Api
import com.example.busticketonlineboking.model.City
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityViewModel: ViewModel() {
    private var city: MutableLiveData<City> = MutableLiveData()
    fun getCity(): MutableLiveData<City> = city

    val api: Api = Api()
    fun loadCity(){
        val apiCall = api.getCity()

        apiCall.enqueue(object : Callback<City>{
            override fun onFailure(call: Call<City>, t: Throwable) {
                Log.d("Result Error>>>>>",t.toString())
            }

            override fun onResponse(call: Call<City>, response: Response<City>) {
                response?.isSuccessful.let {
                    val cityResult = City(response.body()?.loctions?: emptyList())
                    city.value = cityResult
                }
            }
        })
    }
}