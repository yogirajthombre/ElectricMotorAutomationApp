package com.example.electricmotorautomationapp.repository

import CurrentWaterLevelResponseModel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.electricmotorautomationapp.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WaterLevelRepository {

    fun current_water_level(userid: String, token: String): MutableLiveData<CurrentWaterLevelResponseModel> {
        var currentWaterLevel: MutableLiveData<CurrentWaterLevelResponseModel> = MutableLiveData()
        var apiService = ApiClient().create_retrofit_instance_with_header(token = token)
        if (apiService != null) {
         apiService.get_current_water_level(userid).enqueue(object :Callback<CurrentWaterLevelResponseModel>{
             override fun onFailure(call: Call<CurrentWaterLevelResponseModel>, t: Throwable) {

             }

             override fun onResponse(call: Call<CurrentWaterLevelResponseModel>, response: Response<CurrentWaterLevelResponseModel>) {
                 if (response.isSuccessful){
                     currentWaterLevel.value = response.body()
                 }
             }
         })


        }

        return currentWaterLevel




    }
}