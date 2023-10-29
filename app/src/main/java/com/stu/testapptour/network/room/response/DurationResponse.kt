package com.stu.testapptour.network.room.response

import com.google.gson.annotations.SerializedName

data class DurationResponse(
    @SerializedName("night")
    val night: Int
)