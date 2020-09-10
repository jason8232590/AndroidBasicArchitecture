package com.example.myapplication.network

import com.google.gson.annotations.SerializedName
data class RequestResponse<T> (
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: List<T>
)