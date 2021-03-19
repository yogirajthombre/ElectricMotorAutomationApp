package com.example.electricmotorautomationapp.model.CurrentMotorStatus

import MotorStatus
import com.google.gson.annotations.SerializedName

data class CurrentMotorStatusResponseModel(@SerializedName("status") val status : Int,
                                           @SerializedName("message") val message : String,
                                           @SerializedName("data") val data : Boolean,
                                           @SerializedName("errors") val errors : Boolean)

