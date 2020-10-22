package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.network.DaXiongService
import com.example.myapplication.utils.DessertTimer
import com.example.myapplication.viewmodel.MainActivityViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var daXiongService: DaXiongService

    lateinit var viewModel: MainActivityViewModel

    lateinit var dessertTimer: DessertTimer

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        dessertTimer = DessertTimer(this.lifecycle)


    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}