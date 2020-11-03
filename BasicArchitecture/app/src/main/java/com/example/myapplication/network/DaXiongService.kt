package com.example.myapplication.network

import com.example.myapplication.network.entity.LegoSet
import com.example.myapplication.network.entity.LegoTheme
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DaXiongService {

    companion object {
        const val ENDPOINT = "https://rebrickable.com/api/v3/"
    }

    @GET("lego/themes")
    suspend fun getLegoThemes(
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null,
        @Query("ordering") order: Int? = null
    ): Response<ResponseResult<LegoTheme>>

    @GET("lego/sets/")
    suspend fun getStatus(
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null,
        @Query("theme_id") themeId: Int? = null,
        @Query("ordering") order: String? = null
    ): ResponseResult<LegoSet>

    @GET("lego/sets/{id}/")
    suspend fun getSet(@Path("id") id : String) : Response<LegoSet>
}