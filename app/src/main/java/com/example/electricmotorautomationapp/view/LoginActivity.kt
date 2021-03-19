package com.example.electricmotorautomationapp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.electricmotorautomationapp.R
import com.example.electricmotorautomationapp.databinding.ActivityLoginBinding
import com.example.electricmotorautomationapp.viewmodel.LoginViewModel


class LoginActivity : BaseActivity() {
    lateinit var activityLoginBinding:ActivityLoginBinding;
    lateinit var mViewModel: LoginViewModel;
    var baseActivity = BaseActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)



        activityLoginBinding.buttonLogin.setOnClickListener {
            activityLoginBinding.progressbarCircular.visibility = View.VISIBLE

            if (activityLoginBinding.edittextPhoneNumber.text.toString().isEmpty()
                    || activityLoginBinding.edittextPassword.text.toString().isEmpty()){

                Toast.makeText(this,"Empty fields",Toast.LENGTH_LONG).show()

            }else {


                mViewModel.login(activityLoginBinding.edittextPhoneNumber.text.toString(),
                        activityLoginBinding.edittextPassword.text.toString())

                set_up_observers()

            }
        }

    }

    fun set_up_observers(){
        mViewModel.login_response().observe(this, Observer {
            activityLoginBinding.progressbarCircular.visibility = View.GONE
            baseActivity.initialize_shared_preferences(this,userid = it.data.user._id,token = it.data.token)
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })
    }

}

