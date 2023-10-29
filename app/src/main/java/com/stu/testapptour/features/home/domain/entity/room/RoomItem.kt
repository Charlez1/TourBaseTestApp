package com.stu.testapptour.features.home.domain.entity.room

import com.stu.testapptour.features.blog.domain.entity.Image
import com.stu.testapptour.features.home.domain.entity.Content
import com.stu.testapptour.network.room.response.Date

data class RoomItem(
    val id: Int,
    val image: Image,
    val title: String,
    val price: Price,
    val countTourist: Int,
    val type: String
) : Content