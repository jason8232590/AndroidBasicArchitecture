package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.viewmodel.LoginActivityViewModel
import com.example.myapplication.viewmodel.LoginActivityViewModelFactory

class LoginActivity : AppCompatActivity() {

    lateinit var viewModelFactory: LoginActivityViewModelFactory
    lateinit var viewModel: LoginActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //如果有参数的viewmodel,ViewProvider不支持直接初始化这种类型的viewmodel
        //只能通过viewmodelfactory的方式
        viewModelFactory = LoginActivityViewModelFactory(2);
        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginActivityViewModel::class.java)
    }
}