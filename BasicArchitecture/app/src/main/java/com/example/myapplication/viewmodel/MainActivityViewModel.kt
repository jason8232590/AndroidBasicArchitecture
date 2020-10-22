package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    //keep encapsulation so that the filed can only be accessed internal
    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    private var _score = MutableLiveData<Int>()

    val score: LiveData<Int>
        get() = _score

//    val scoreStr: LiveData<String>
//        get() = _score.value.toString()

    init {
        _score.value = 30
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun addTextViewValue(){
        // only use this is useless
        _score.value = _score.value?.plus(1)
        println("xcqw   555555")
    }
}