package com.stu.testapptour.features.home.domain.entity.tour

import com.stu.testapptour.features.blog.domain.entity.Image
import com.stu.testapptour.features.home.domain.entity.Content

data class TourItem(
    val id: Int,
    val url: String,
    val image: Image,
    val title: String,
    val location: String,
    val date: TourDate,
    val duration: TourDuration,
    val price: TourPrice,
    val home: TourHome
) : Content
