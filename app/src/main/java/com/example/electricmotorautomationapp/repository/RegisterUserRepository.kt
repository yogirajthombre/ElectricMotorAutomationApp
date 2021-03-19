package com.example.electricmotorautomationapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.electricmotorautomationapp.api.ApiClient
import com.example.electricmotorautomationapp.api.ApiService
import com.example.electricmotorautomationapp.model.UserRegistration.RegisterNewUser
import com.example.electricmotorautomationapp.model.UserRegistration.RegisterUserResponseModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class RegisterUserRepository {
    lateinit var registerUserResponseModel : MutableLiveData<RegisterUserResponseModel>;
    var apiService:ApiService;

    init {
        apiService = ApiClient().create_retrofit_instance();
    }


    fun register_new_user(registerNewUser: RegisterNewUser):MutableLiveData<RegisterUserResponseModel>{

        apiService.register_new_user(registerNewUser).enqueue(object :retrofit2.Callback<RegisterUserResponseModel>{
            override fun onFailure(call: Call<RegisterUserResponseModel>, t: Throwable) {

            }

            override fun onResponse(
                    call: Call<RegisterUserResponseModel>,
                    response: Response<RegisterUserResponseModel>
            ) {
                if (response.isSuccessful){
                    registerUserResponseModel.value = response.body();
                }

            }

        })


        return registerUserResponseModel;
    }


}