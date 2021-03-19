package com.example.electricmotorautomationapp.model.UserLogin

import com.google.gson.annotations.SerializedName

data class LoginUser(@SerializedName("phoneNumber") val phoneNumber:String,@SerializedName("password") val password:String)
