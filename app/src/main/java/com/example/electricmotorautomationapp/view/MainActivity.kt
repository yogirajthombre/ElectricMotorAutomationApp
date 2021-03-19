package com.example.electricmotorautomationapp.view



import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.electricmotorautomationapp.R
import com.example.electricmotorautomationapp.databinding.ActivityMainBinding
import com.example.electricmotorautomationapp.viewmodel.MainActivityViewModel


class MainActivity : BaseActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mViewModel:MainActivityViewModel;
    private var handler: Handler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        var sharedPreferences  = getSharedPreferences("SHARED_PREFERENCES", Context.MODE_PRIVATE)
        val userid: String? = sharedPreferences.getString("userid",null)
        val token: String? = sharedPreferences.getString("token",null)
        if (userid != null) {
            if (token != null) {
              mViewModel.init(userid=userid, token=token)
            }
        }



        get_current_water_level()
        get_current_motor_status()
        set_up_observer()


        handler.postDelayed({
            update_water_level()
        },1000)

    }

    private fun set_up_observer() {
        mViewModel.currentwaterlevelResponse().observe(this, Observer {
            activityMainBinding.textWaterLevel.text = it.data.waterLevel.toString()+"   "+"Litres"
        })

        mViewModel.current_motor_status_response().observe(this, Observer {
            if (it.data == true){
                activityMainBinding.textMotorStatus.text = "Running"
            }else {
                activityMainBinding.textMotorStatus.text = "Not Running"
            }
        })
    }

    private fun get_current_motor_status() {
       mViewModel.get_current_motor_status()
        mViewModel.current_motor_status_response().observe(this, Observer {
            if (it.data == true){
                activityMainBinding.textMotorStatus.text = "Running"
            }else {
                activityMainBinding.textMotorStatus.text = "Not Running"
            }

        })

    }

    private fun get_current_water_level() {
       mViewModel.get_current_water_level()
        mViewModel.currentwaterlevelResponse().observe(this, Observer {
            activityMainBinding.textWaterLevel.text = it.data.waterLevel.toString()+"   "+"Litres"
        })
    }





    fun update_water_level(){
        get_current_water_level()
        get_current_motor_status()
        handler.postDelayed({
            update_water_level()
        },1000)


    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAffinity()
    }

    }


