package com.stu.testapptour.features.home.domain.usecase

import com.stu.testapptour.features.home.domain.entity.Content
import com.stu.testapptour.features.home.domain.entity.ObjectType
import com.stu.testapptour.features.home.domain.entity.home.MainPageData
import com.stu.testapptour.features.home.repository.HomeRepository
import javax.inject.Inject

class GetMainPageDataUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend fun getMainPageData(): MainPageData {
        val mainPageData = repository.getHomePageData()
        val sectionList = mainPageData.allSectionList.map {
            it.copy(
                data = getMainPageContentList(
                    objectType = it.template.objectType,
                    url = it.url
                )
            )
        }
        return mainPageData.copy(allSectionList = sectionList)
    }

    private suspend fun getMainPageContentList(objectType: ObjectType, url: String) : List<Content> {
        return when (objectType) {
            ObjectType.OBJECT -> repository.getObjectList(url)
            ObjectType.BLOG -> repository.getBlogList()
            ObjectType.ROOM -> repository.getRoomList()
            ObjectType.TOUR -> repository.getTourList()
        }
    }
}