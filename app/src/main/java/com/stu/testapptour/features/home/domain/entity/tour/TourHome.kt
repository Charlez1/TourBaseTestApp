package com.stu.testapptour.features.home.domain.entity.tour

import com.stu.testapptour.features.blog.domain.entity.Image

data class TourHome(
    val id: Int,
    val name: String,
    val type: String,
    val night: Int,
    val url: String,
    val image: Image,
    val base: TourBase
)
