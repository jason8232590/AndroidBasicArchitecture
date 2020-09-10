package com.example.myapplication.base

import android.app.Application
import android.os.Build
import com.example.myapplication.BuildConfig
import com.facebook.stetho.Stetho

class DxApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Stetho.initializeWithDefaults(this)
        }
    }
}