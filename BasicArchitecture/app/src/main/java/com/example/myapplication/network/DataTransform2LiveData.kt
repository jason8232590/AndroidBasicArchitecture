package com.example.myapplication.network

import androidx.lifecycle.distinctUntilChanged
import com.example.myapplication.network.entity.LegoSet
import javax.inject.Inject

class DataTransform2LiveData @Inject constructor(val remoteDataSource: RemoteDataSource){

    fun observeSet(id: String) = Transform2LiveDataUtils(
        networkCall = { remoteDataSource.fetchSet(id) })
        .distinctUntilChanged()
}