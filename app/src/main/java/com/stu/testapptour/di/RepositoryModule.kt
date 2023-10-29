package com.stu.testapptour.di

import com.stu.testapptour.features.blog.repository.BlogRepository
import com.stu.testapptour.features.blog.repository.BlogRepositoryImpl
import com.stu.testapptour.features.home.repository.HomeRepository
import com.stu.testapptour.features.home.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindBlogRepository(
        blogRepositoryImpl: BlogRepositoryImpl
    ): BlogRepository

    @Binds
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
}