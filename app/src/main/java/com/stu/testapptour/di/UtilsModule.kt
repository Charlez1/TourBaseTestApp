package com.stu.testapptour.di

import com.stu.testapptour.utils.UrlParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UtilsModule {

    @Provides
    @Singleton
    fun provideUrlParser(): UrlParser {
        return UrlParser()
    }
}