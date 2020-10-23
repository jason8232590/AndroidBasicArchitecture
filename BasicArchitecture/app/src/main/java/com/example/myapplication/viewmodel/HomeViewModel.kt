package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.DaXiongService
import javax.inject.Inject

class HomeViewModel @Inject constructor(var daXiongService: DaXiongService) : ViewModel() {

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> = _error

    private val _age = MutableLiveData<Int>()
    val age: LiveData<Int> = _age

    init {
        _age.value = 10
    }
}