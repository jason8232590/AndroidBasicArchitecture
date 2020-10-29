package com.example.myapplication.Service

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.IBinder

class MyConnection : ServiceConnection {
    lateinit var myBinder : IService
    override fun onServiceDisconnected(name: ComponentName?) {
        println("xcqw onServiceDisconnected")
    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        myBinder = service as IService
    }
}