package com.example.myapplication.network.entity

import androidx.lifecycle.LiveData

class TestLiveData<T> constructor(var content:T) : LiveData<T>(){

    override fun onActive() {
        super.onActive()
        println("xcqw TestLiveData onActive")
    }

    override fun onInactive() {
        super.onInactive()
        println("xcqw TestLiveData onInactive")

    }
}