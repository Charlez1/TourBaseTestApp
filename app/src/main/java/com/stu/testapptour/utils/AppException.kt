package com.stu.testapptour.utils

import com.google.gson.annotations.SerializedName

open class AppException : RuntimeException {
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(cause: Throwable) : super(cause)
}


class NetworkException(
    val name: String,
    val status: String,
    val code: String,
    val errorMessage: String
) : AppException(errorMessage)
