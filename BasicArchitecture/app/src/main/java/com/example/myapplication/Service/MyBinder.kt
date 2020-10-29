package com.example.myapplication.Service

import android.os.Binder
import android.os.IBinder

class MyBinder : Binder(), IService {
    override fun callBackMethodService(money: Int) {
        if(money > 1000){
            println("xcqw money > 1000")
        }else{
            println("xcqw else money")
        }
    }

    override fun asBinder(): IBinder {
        TODO("Not yet implemented")
    }
}