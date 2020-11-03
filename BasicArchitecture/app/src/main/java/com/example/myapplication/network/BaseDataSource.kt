package com.example.myapplication.network

import retrofit2.Response

/**
 * 做error handling
 * */
abstract class BaseDataSource {

    //原始数据转换成  适合后续处理 result(包含 status, message ,data)
    suspend fun <T> transformToResult(call: suspend() -> Response<T>): Result<T>{
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        return Result.error("Network call has failed for a following reason: $message")
    }
}