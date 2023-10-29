package com.stu.testapptour.features.home.repository

import com.stu.testapptour.features.home.domain.entity.blog.BlogItem
import com.stu.testapptour.features.home.domain.entity.home.MainPageData
import com.stu.testapptour.features.home.domain.entity.`object`.ObjectItem
import com.stu.testapptour.features.home.domain.entity.room.RoomItem
import com.stu.testapptour.features.home.domain.entity.tour.TourItem
import com.stu.testapptour.network.blog.BlogApiService
import com.stu.testapptour.network.main.MainApiService
import com.stu.testapptour.network.`object`.ObjectApiService
import com.stu.testapptour.network.room.RoomApiService
import com.stu.testapptour.network.tour.TourApiService
import com.stu.testapptour.utils.UrlParser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImpl @Inject constructor(
    private val mainApiService: MainApiService,
    private val roomApiService: RoomApiService,
    private val blogApiService: BlogApiService,
    private val objectApiService: ObjectApiService,
    private val tourApiService: TourApiService,
    private val urlParser: UrlParser
) : HomeRepository {

    override suspend fun getHomePageData(): MainPageData {
        return mainApiService.getMainPageData().toMainPageData()
    }

    override suspend fun getBlogList(): List<BlogItem> {
        return blogApiService.getBlogList().toBlogList()
    }

    override suspend fun getObjectList(url: String): List<ObjectItem> {
        val type = urlParser.parseTypeFromUrl(url)
        return objectApiService.getObjectList(
            type = type ?: ""
        ).toObjectList()
    }

    override suspend fun getRoomList(): List<RoomItem> {
        return roomApiService.getRoomList().toRoomList()
    }

    override suspend fun getTourList(): List<TourItem> {
        return tourApiService.getTourList().toTourList()
    }
}