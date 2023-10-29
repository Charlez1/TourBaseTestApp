package com.stu.testapptour.features.home.repository

import com.stu.testapptour.features.home.domain.entity.home.MainPageData
import com.stu.testapptour.features.home.domain.entity.blog.BlogItem
import com.stu.testapptour.features.home.domain.entity.`object`.ObjectItem
import com.stu.testapptour.features.home.domain.entity.room.RoomItem
import com.stu.testapptour.features.home.domain.entity.tour.TourItem

interface HomeRepository {

    suspend fun getHomePageData() : MainPageData

    suspend fun getBlogList() : List<BlogItem>

    suspend fun getObjectList(url: String) : List<ObjectItem>

    suspend fun getRoomList() : List<RoomItem>

    suspend fun getTourList(): List<TourItem>
}