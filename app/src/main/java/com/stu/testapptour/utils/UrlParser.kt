package com.stu.testapptour.utils

import java.net.URI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UrlParser @Inject constructor() {
    fun parseTypeFromUrl(url: String): String? {
        val uri = URI(url)
        return uri.getQuery().split("&")
            .find { it.startsWith("type=") }
            ?.substringAfter("type=")
    }
}

