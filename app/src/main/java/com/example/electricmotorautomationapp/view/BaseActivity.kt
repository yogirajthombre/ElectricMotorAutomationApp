package com.example.electricmotorautomationapp.view

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity() : AppCompatActivity() {

    open lateinit var sharedPreferences: SharedPreferences ;

    fun initialize_shared_preferences(context: Context,userid:String,token:String){

           sharedPreferences  = context.getSharedPreferences("SHARED_PREFERENCES",Context.MODE_PRIVATE)
           val editor : SharedPreferences.Editor = sharedPreferences.edit()
           editor.putString("userid",userid)
           editor.putString("token",token)
           editor.apply()
    }

}