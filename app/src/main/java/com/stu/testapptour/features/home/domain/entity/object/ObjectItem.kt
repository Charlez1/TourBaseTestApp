package com.stu.testapptour.features.home.domain.entity.`object`

import com.stu.testapptour.features.blog.domain.entity.Image
import com.stu.testapptour.features.home.domain.entity.Content

data class ObjectItem(
    val id: Int,
    val image: Image,
    val title: String,
    val subtitle: String
): Content
