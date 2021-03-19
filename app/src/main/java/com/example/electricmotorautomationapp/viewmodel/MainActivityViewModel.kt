package com.example.electricmotorautomationapp.viewmodel

import CurrentWaterLevelResponseModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.electricmotorautomationapp.model.CurrentMotorStatus.ControlMotorOperation
import com.example.electricmotorautomationapp.model.CurrentMotorStatus.CurrentMotorStatusResponseModel
import com.example.electricmotorautomationapp.repository.MotorStatusRepository
import com.example.electricmotorautomationapp.repository.WaterLevelRepository

class MainActivityViewModel : ViewModel() {

    private lateinit var userid:String;
    private lateinit var token:String ;
    private lateinit var currentwaterlevel: MutableLiveData<CurrentWaterLevelResponseModel>
    private lateinit var controlmotoroperation : MutableLiveData<ControlMotorOperation>
    private lateinit var currentMotorStatusResponseModel: MutableLiveData<CurrentMotorStatusResponseModel>


    fun init(userid:String,token:String){
        this.userid = userid
        this.token = token
    }

    fun get_current_water_level(){
        currentwaterlevel =  WaterLevelRepository().current_water_level(userid=userid,token=token)
    }

    fun get_current_motor_status(){
        currentMotorStatusResponseModel = MotorStatusRepository().get_motor_status(userid=userid, token=token)
    }

    fun control_motor_operation(){
        controlmotoroperation =  MotorStatusRepository().control_motor_operation(userid=userid, token=token)

    }

    fun currentwaterlevelResponse(): MutableLiveData<CurrentWaterLevelResponseModel> = currentwaterlevel

    fun current_motor_status_response(): LiveData<CurrentMotorStatusResponseModel> = currentMotorStatusResponseModel;

    fun control_motor_operation_response(): LiveData<ControlMotorOperation> = controlmotoroperation







}