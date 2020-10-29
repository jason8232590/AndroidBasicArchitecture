package com.example.myapplication.network

import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import retrofit2.Response


abstract class BaseObserver<T> : Observer<RequestResult<T>> {
    val TAG = "BaseObserber"

    override fun onSubscribe(d: Disposable) {
        println("onSubscribe")
    }

    override fun onNext(value: RequestResult<T>) {
//        if (value.code()  == 200) {
//            onSuccess(value.data())
//        } else {
//            onFailure(null, value.errorBody().toString())
//        }
        if(value.results != null ){
            onSuccess(value)
        }else{
            onFailure(value,"fail")
        }
    }


    override fun onError(error: Throwable) {
    }

    override fun onComplete() {
    }

    abstract fun onFailure(t: RequestResult<T>?, message: String?)


    abstract fun onSuccess(data: RequestResult<T>)
}