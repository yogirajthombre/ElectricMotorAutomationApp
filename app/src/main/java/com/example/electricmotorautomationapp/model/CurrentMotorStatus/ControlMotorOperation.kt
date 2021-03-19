package com.example.electricmotorautomationapp.model.CurrentMotorStatus

import MotorStatus
import com.google.gson.annotations.SerializedName

data class ControlMotorOperation(@SerializedName("status") val status : Int,
                                 @SerializedName("message") val message : String,
                                 @SerializedName("data") val data : MotorStatus,
                                 @SerializedName("errors") val errors : Boolean)


