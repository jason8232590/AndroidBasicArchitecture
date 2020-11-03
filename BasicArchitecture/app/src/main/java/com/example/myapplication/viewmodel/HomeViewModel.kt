package com.example.myapplication.viewmodel

import android.service.autofill.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.DaXiongService
import com.example.myapplication.network.DataTransform2LiveData
import com.example.myapplication.network.Transform2LiveDataUtils
import com.example.myapplication.network.entity.TestLiveData
import javax.inject.Inject

class HomeViewModel @Inject constructor(var transform2LiveData: DataTransform2LiveData) : ViewModel() {

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> = _error

    private val _age = MutableLiveData<Int>()
    val age: LiveData<Int> = _age

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    val customizeName:LiveData<String> = Transformations.map(name){
         "江西 $it"
    }

    init {
        _age.value = 10
        _name.value = "大熊"
    }

    lateinit var id :String

    val legoSet by lazy { transform2LiveData.observeSet(id)}


}