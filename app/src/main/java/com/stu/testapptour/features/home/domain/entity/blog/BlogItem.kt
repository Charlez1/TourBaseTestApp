package com.stu.testapptour.features.home.domain.entity.blog

import com.stu.testapptour.features.blog.domain.entity.Image
import com.stu.testapptour.features.home.domain.entity.Content
import java.util.Date

data class BlogItem(
    val id: Int,
    val image: Image,
    val title: String,
    val subtitle: String,
    val view: Int,
    val like: Int,
    val date: Date
): Content