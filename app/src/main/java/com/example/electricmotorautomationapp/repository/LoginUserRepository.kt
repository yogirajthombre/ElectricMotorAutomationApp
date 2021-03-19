package com.example.electricmotorautomationapp.repository

import LoginUserResponseModel
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.electricmotorautomationapp.api.ApiClient
import com.example.electricmotorautomationapp.api.ApiService
import com.example.electricmotorautomationapp.model.UserLogin.LoginUser
import retrofit2.Call
import retrofit2.Response

class LoginUserRepository {




    fun login_user(loginUser: LoginUser): MutableLiveData<LoginUserResponseModel> {
        var loginUserResponseModel:MutableLiveData<LoginUserResponseModel> = MutableLiveData()
        var apiService = ApiClient().create_retrofit_instance();
        if (apiService != null) {
            apiService.login_user(loginUser).enqueue(object : retrofit2.Callback<LoginUserResponseModel> {
                override fun onFailure(call: Call<LoginUserResponseModel>, t: Throwable) {

                }

                override fun onResponse(
                        call: Call<LoginUserResponseModel>,
                        response: Response<LoginUserResponseModel>
                ) {
                    if (response.isSuccessful){

                        loginUserResponseModel.value = response.body()

                    }
                }


            })
        }


        return loginUserResponseModel;
    }


}