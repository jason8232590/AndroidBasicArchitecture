package com.example.myapplication.Service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class TestService : Service(){
    override fun onCreate() {
        super.onCreate()
        print("onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        print("onStartCommand")
        return super.onStartCommand(intent, flags, startId)

    }

    override fun onStart(intent: Intent?, startId: Int) {
        print("onStart")
        super.onStart(intent, startId)
    }

    override fun onDestroy() {
        print("Service onDestroy")
        super.onDestroy()

    }

    override fun onBind(intent: Intent?): IBinder? {
        println("xcqwe  onBind")
        return MyBinder()
    }

    fun methodService() {
        println("xcqw 给你办证了")
        //Toast.makeText(this, "给你办证了", 0).show();
    }

    inline fun  print( str : String){
        println("xcqwe  $str")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        print("onUnbind")
        return super.onUnbind(intent)
    }


}