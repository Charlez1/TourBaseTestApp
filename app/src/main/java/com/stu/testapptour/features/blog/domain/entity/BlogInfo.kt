package com.stu.testapptour.features.blog.domain.entity

import java.util.Date

data class BlogInfo(
    val id: Int,
    val image: Image,
    val title: String,
    val subtitle: String,
    val like: Int,
    val date: Date,
    val url: String,
    val content: String
)