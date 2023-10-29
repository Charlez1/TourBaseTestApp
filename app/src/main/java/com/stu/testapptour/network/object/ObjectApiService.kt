package com.stu.testapptour.network.`object`

import com.stu.testapptour.network.`object`.response.ObjectResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ObjectApiService {

    @GET("base-app/fun")
    suspend fun getObjectList(
        @Query("id") id: Int = 117,
        @Query("type") type: String,
    ): ObjectResponse
}