package com.stu.testapptour.network.blog

import com.stu.testapptour.network.blog.response.info.BlogInfoResponse
import com.stu.testapptour.network.blog.response.list.BlogListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BlogApiService {

    @GET("base-app/blog")
    suspend fun getBlogList(
        @Query("id") id: Int = 117,
        @Query("format") format: String = "card" //todo replace base query
    ): BlogListResponse

    @GET("base-app/blog-info")
    suspend fun getBlogInfo(
        @Query("id") id: Int = 117,
        @Query("blog_id") blogId: Int
    ): BlogInfoResponse
}