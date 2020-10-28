package com.example.myapplication.network

import android.icu.util.TimeUnit
import androidx.lifecycle.LifecycleOwner
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.schedulers.Schedulers
import com.trello.rxlifecycle3.android.lifecycle.kotlin.bindToLifecycle


object NetScheduler{
    fun <T> compose(): ObservableTransformer<T, T> {

        return ObservableTransformer { observable ->
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(mainThread())
                .debounce(1, java.util.concurrent.TimeUnit.SECONDS)
        }
    }

}