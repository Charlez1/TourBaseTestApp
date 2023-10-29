package com.stu.testapptour.network.blog.response

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.Date

data class DateResponse(
    @SerializedName("typeDate")
    val typeDate: String,
    @SerializedName("date")
    val date: String
) {
    fun toDate(): Date {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return format.parse(date)
    }
}