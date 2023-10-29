package com.stu.testapptour.features.blog.domain.usecase

import com.stu.testapptour.features.blog.domain.entity.BlogInfo
import com.stu.testapptour.features.blog.repository.BlogRepository
import com.stu.testapptour.features.home.domain.entity.home.MainPageData
import com.stu.testapptour.features.home.repository.HomeRepository
import javax.inject.Inject

class GetBlogInfoUseCase @Inject constructor(
    private val repository: BlogRepository
) {
    suspend fun getBlogInfo(blogId: Int): BlogInfo {
        return repository.getBlogInfo(blogId)
    }
}