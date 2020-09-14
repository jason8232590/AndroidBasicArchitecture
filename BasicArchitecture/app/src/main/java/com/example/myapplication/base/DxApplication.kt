package com.example.myapplication.base

import android.app.Application
import com.example.myapplication.BuildConfig
import com.example.myapplication.di.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class DxApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Stetho.initializeWithDefaults(this)
        }

        DaggerAppComponent.builder().application(this)
            .build().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any?>? {
        return dispatchingAndroidInjector
    }
}