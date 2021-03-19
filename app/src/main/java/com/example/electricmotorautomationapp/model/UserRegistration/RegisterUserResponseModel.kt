package com.example.electricmotorautomationapp.model.UserRegistration

import Data
import MotorStatus
import com.google.gson.annotations.SerializedName

data class RegisterUserResponseModel(@SerializedName("status") val status : Int,
                                     @SerializedName("message") val message : String,
                                     @SerializedName("data") val data : Data,
                                     @SerializedName("errors") val errors : Boolean)



