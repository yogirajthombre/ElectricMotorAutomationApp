package com.example.electricmotorautomationapp.viewmodel

import LoginUserResponseModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.electricmotorautomationapp.model.UserLogin.LoginUser
import com.example.electricmotorautomationapp.repository.LoginUserRepository

class LoginViewModel : ViewModel() {

    var loginUserResponse: MutableLiveData<LoginUserResponseModel> = MutableLiveData()



    fun login(phoneNumber:String,password:String) {
        loginUserResponse = LoginUserRepository().login_user(LoginUser(phoneNumber, password))
    }

    fun login_response(): LiveData<LoginUserResponseModel> = loginUserResponse






}