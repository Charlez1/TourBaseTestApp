package com.stu.testapptour.network.tour

import com.stu.testapptour.network.`object`.response.ObjectResponse
import com.stu.testapptour.network.tour.response.TourResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TourApiService {

    @GET("base-app/tours")
    suspend fun getTourList(
        @Query("id") id: Int = 117,
    ): TourResponse
}