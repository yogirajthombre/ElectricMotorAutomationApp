package com.example.electricmotorautomationapp.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.electricmotorautomationapp.R
import com.example.electricmotorautomationapp.databinding.ActivityWelcomeBinding

class WelcomeActivity : BaseActivity() {
    lateinit var activityWelcomeBinding: ActivityWelcomeBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityWelcomeBinding = DataBindingUtil.setContentView(this,R.layout.activity_welcome)
        activityWelcomeBinding.buttonLogin.setOnClickListener {
            var intent = Intent(this,LoginActivity::class.java);
            startActivity(intent)
        }
        activityWelcomeBinding.buttonRegister.setOnClickListener {
            var intent = Intent(this,RegisterActivity::class.java);
            startActivity(intent)
        }

       sharedPreferences  = getSharedPreferences("SHARED_PREFERENCES", Context.MODE_PRIVATE)

        if(sharedPreferences.getString("userid",null) != null &&
                sharedPreferences.getString("token",null) != null){
            var intent = Intent(this,MainActivity::class.java);
            startActivity(intent)
        }


    }
}


