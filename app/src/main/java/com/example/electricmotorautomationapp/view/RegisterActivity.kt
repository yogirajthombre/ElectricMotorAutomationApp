package com.example.electricmotorautomationapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.electricmotorautomationapp.R
import com.example.electricmotorautomationapp.databinding.ActivityRegisterBinding
import com.example.electricmotorautomationapp.viewmodel.RegisterViewModel


class RegisterActivity : AppCompatActivity() {

     lateinit var activityRegisterBinding: ActivityRegisterBinding;
     lateinit var mViewModel: RegisterViewModel;
     var baseActivity = BaseActivity()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterBinding = DataBindingUtil.setContentView(this,R.layout.activity_register)
        mViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)


        activityRegisterBinding.buttonRegister.setOnClickListener {

            activityRegisterBinding.progressbarCircular.visibility = View.VISIBLE

            if (activityRegisterBinding.edittextPhoneNumber.text.toString().isNotEmpty() ||
                    activityRegisterBinding.edittextPassword.text.toString().isNotEmpty()){

                mViewModel.register_user(activityRegisterBinding.edittextPhoneNumber.text.toString(),activityRegisterBinding.edittextPassword.text.toString())
                set_up_observers()
            }else {
                Toast.makeText(this,"Empty fields",Toast.LENGTH_LONG).show()
            }
        }

    }

    fun set_up_observers(){
        mViewModel.register_user_response().observe(this, Observer {
            activityRegisterBinding.progressbarCircular.visibility = View.GONE
            baseActivity.initialize_shared_preferences(this,userid = it.data.user._id,token = it.data.token)
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })

    }

}