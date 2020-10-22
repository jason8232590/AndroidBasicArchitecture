package com.example.myapplication.utils

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class DessertTimer(lifecycle: Lifecycle) : LifecycleObserver{

    init {
        lifecycle.addObserver(this)
    }



    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startTimer(){
        println("xcqw startTimer")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopTimer(){
        println("xcqw stopTimer")

    }

}