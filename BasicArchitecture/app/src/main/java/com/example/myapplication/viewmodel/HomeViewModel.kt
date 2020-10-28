package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.BaseObserver
import com.example.myapplication.network.DaXiongService
import com.example.myapplication.network.NetScheduler
import com.example.myapplication.network.RequestResult
import com.example.myapplication.network.entity.LegoSet
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
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

    fun GetThemes() {

        daXiongService.getSet("1")
            .compose(NetScheduler.compose())
            .subscribe(object : BaseObserver<LegoSet>(){
                override fun onFailure(t: RequestResult<LegoSet>?, message: String?) {
                    println("xcqw onFailure")

                }

                override fun onSuccess(data: RequestResult<LegoSet>) {
                    println("xcqw onSuccess")
                }

            })


    }
}