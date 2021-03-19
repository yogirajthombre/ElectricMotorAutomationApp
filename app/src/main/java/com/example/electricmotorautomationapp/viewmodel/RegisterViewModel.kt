package com.example.electricmotorautomationapp.viewmodel



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.electricmotorautomationapp.model.UserRegistration.RegisterNewUser
import com.example.electricmotorautomationapp.model.UserRegistration.RegisterUserResponseModel
import com.example.electricmotorautomationapp.repository.RegisterUserRepository

class RegisterViewModel() : ViewModel() {
    var register_user:MutableLiveData<RegisterUserResponseModel> = MutableLiveData()

    fun register_user(phoneNumber:String,password:String) {
        register_user = RegisterUserRepository().register_new_user(RegisterNewUser(phoneNumber,password));
    }

    open fun register_user_response(): LiveData<RegisterUserResponseModel> = register_user


}

