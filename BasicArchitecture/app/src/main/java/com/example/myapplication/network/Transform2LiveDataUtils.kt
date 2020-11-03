package com.example.myapplication.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

/**
 * 把result 转换成 livedata 这样就可以发出 success error等消息，然后再代码中做相应处理
 *
 * */
fun <T> Transform2LiveDataUtils(
                          networkCall: suspend () -> Result<T>,
                          ): LiveData<Result<T>> =
    liveData(Dispatchers.IO) {
        emit(Result.loading<T>())
        //这里还有一个离线展示的功能,后续添加
        val responseResult = networkCall.invoke()
        var data:LiveData<T> = liveData {
            emit(responseResult.data!!)
        }
        var source:LiveData<Result<T>> = data.map { Result.success(it) }
        if (responseResult.status == Result.Status.SUCCESS) {
            emitSource(source)
        } else if (responseResult.status == Result.Status.ERROR) {
            emit(Result.error<T>(responseResult.message!!))
//            emitSource(source)
        }
    }