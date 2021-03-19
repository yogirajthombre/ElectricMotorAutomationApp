package com.example.electricmotorautomationapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.electricmotorautomationapp.api.ApiClient
import com.example.electricmotorautomationapp.model.CurrentMotorStatus.ControlMotorOperation
import com.example.electricmotorautomationapp.model.CurrentMotorStatus.CurrentMotorStatusResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MotorStatusRepository {

    fun get_motor_status(userid: String, token: String): MutableLiveData<CurrentMotorStatusResponseModel> {
        var currentMotorStatus: MutableLiveData<CurrentMotorStatusResponseModel> = MutableLiveData()
        var apiService = ApiClient().create_retrofit_instance_with_header(token = token)
        if (apiService != null) {
            apiService.get_current_motor_status(uid=userid).enqueue(object : Callback<CurrentMotorStatusResponseModel> {
                override fun onFailure(call: Call<CurrentMotorStatusResponseModel>, t: Throwable) {


                }

                override fun onResponse(call: Call<CurrentMotorStatusResponseModel>, response: Response<CurrentMotorStatusResponseModel>) {
                    if (response.isSuccessful){
                        currentMotorStatus.value = response.body()
                    }
                }
            })


        }

        return currentMotorStatus

    }


    fun control_motor_operation(userid: String, token: String): MutableLiveData<ControlMotorOperation> {
        var controlMotorOperation: MutableLiveData<ControlMotorOperation> = MutableLiveData()
        var apiService = ApiClient().create_retrofit_instance_with_header(token = token)
        if (apiService != null) {
            apiService.control_motor(uid = userid).enqueue(object :Callback<ControlMotorOperation>{
                override fun onFailure(call: Call<ControlMotorOperation>, t: Throwable) {



                }

                override fun onResponse(call: Call<ControlMotorOperation>, response: Response<ControlMotorOperation>) {
                    if (response.isSuccessful){
                        controlMotorOperation.value = response.body()
                    }
                }
            })


        }

        return controlMotorOperation




    }
}