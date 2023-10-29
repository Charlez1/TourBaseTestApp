package com.stu.testapptour.network.room

import com.stu.testapptour.network.room.response.RoomResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RoomApiService {

    @GET("base-app/rooms")
    suspend fun getRoomList(
        @Query("id") id: Int = 117,
    ): RoomResponse

}