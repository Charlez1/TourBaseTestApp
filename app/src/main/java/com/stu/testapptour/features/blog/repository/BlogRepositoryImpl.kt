package com.stu.testapptour.features.blog.repository

import com.stu.testapptour.features.blog.domain.entity.BlogInfo
import com.stu.testapptour.features.home.domain.entity.blog.BlogItem
import com.stu.testapptour.network.blog.BlogApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BlogRepositoryImpl @Inject constructor(
    private val blogApiService: BlogApiService
) : BlogRepository {

    override suspend fun getBlogInfo(blogId: Int): BlogInfo {
        return blogApiService.getBlogInfo(blogId = blogId).toBlogInfo()
    }
}