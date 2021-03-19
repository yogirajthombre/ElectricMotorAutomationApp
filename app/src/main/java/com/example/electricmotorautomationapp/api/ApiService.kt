package com.example.electricmotorautomationapp.api

import CurrentWaterLevelResponseModel
import LoginUserResponseModel
import com.example.electricmotorautomationapp.model.CurrentMotorStatus.ControlMotorOperation
import com.example.electricmotorautomationapp.model.CurrentMotorStatus.CurrentMotorStatusResponseModel
import com.example.electricmotorautomationapp.model.UserLogin.LoginUser
import com.example.electricmotorautomationapp.model.UserRegistration.RegisterNewUser
import com.example.electricmotorautomationapp.model.UserRegistration.RegisterUserResponseModel
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    @POST("register")
    fun register_new_user(@Body registerNewUser: RegisterNewUser): Call<RegisterUserResponseModel>

    @POST("login")
    fun login_user(@Body loginUser: LoginUser):Call<LoginUserResponseModel>

    @GET("waterlevel/{uid}/getWaterlevel")
    fun get_current_water_level(@Path("uid") uid:String): Call<CurrentWaterLevelResponseModel>

    @GET("motor/{uid}/getMotorStatus")
    fun get_current_motor_status(@Path("uid") uid:String): Call<CurrentMotorStatusResponseModel>


    @PUT("motor/{uid}/controlMotor")
    fun control_motor(@Path("uid") uid:String): Call<ControlMotorOperation>

}