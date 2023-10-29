package com.stu.testapptour.network.room.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.room.RoomItem
import com.stu.testapptour.network.ErrorResponse

data class RoomResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("error")
    val error: ErrorResponse,
    @SerializedName("time")
    val time: String,
    @SerializedName("data")
    val data: List<RoomItemResponse>
) {
    fun toRoomList() : List<RoomItem> {
        if(success)
            return data.map { it.toRoomItem() }
        else
            error.throwNetworkException()
    }
}