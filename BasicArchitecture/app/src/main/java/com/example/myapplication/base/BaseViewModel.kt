package com.example.myapplication.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    private var _isLoading = MutableLiveData<Boolean>()

    val isLoading : LiveData<Boolean>
        get() = _isLoading

    fun loadingFinish(){
        _isLoading.value = false
    }

    fun loadingStart(){
        _isLoading.value = true
    }
}