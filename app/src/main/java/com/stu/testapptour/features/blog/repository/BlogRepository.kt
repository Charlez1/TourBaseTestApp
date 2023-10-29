package com.stu.testapptour.features.blog.repository

import com.stu.testapptour.features.blog.domain.entity.BlogInfo
import com.stu.testapptour.features.home.domain.entity.blog.BlogItem

interface BlogRepository {

    suspend fun getBlogInfo(blogId: Int) : BlogInfo

}