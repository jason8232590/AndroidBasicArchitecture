package com.example.myapplication.network

import javax.inject.Inject

/**
 * 从后台获取数据并转换成
 * */
class RemoteDataSource @Inject constructor(val daXiongService: DaXiongService) : BaseDataSource() {

    //把原始数据 转换成 result（包含status, message ,data） 方便后续处理
    suspend fun fetchSet(id:String) = transformToResult{daXiongService.getSet(id)}


}