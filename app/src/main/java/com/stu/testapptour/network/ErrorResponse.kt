package com.stu.testapptour.network

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.utils.NetworkException

data class ErrorResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("message")
    val message: String
) {
    fun throwNetworkException(): Nothing = throw NetworkException(
        name = name,
        status = status,
        code = code,
        errorMessage = message
    )

}