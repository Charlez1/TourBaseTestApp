package com.stu.testapptour.network.main

import com.stu.testapptour.network.main.response.MainPageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApiService {

    @GET("base-app/main")
    suspend fun getMainPageData(
        @Query("id") id: Int = 117
    ) : MainPageResponse
}