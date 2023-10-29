package com.stu.testapptour.di

import com.stu.testapptour.network.ApiConstants
import com.stu.testapptour.network.blog.BlogApiService
import com.stu.testapptour.network.main.MainApiService
import com.stu.testapptour.network.`object`.ObjectApiService
import com.stu.testapptour.network.room.RoomApiService
import com.stu.testapptour.network.tour.TourApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideBlogApiService(retrofit: Retrofit): BlogApiService {
        return retrofit.create(BlogApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideHomeApiService(retrofit: Retrofit): MainApiService {
        return retrofit.create(MainApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomApiService(retrofit: Retrofit): RoomApiService {
        return retrofit.create(RoomApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideObjectApiService(retrofit: Retrofit): ObjectApiService {
        return retrofit.create(ObjectApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideTourApiService(retrofit: Retrofit): TourApiService {
        return retrofit.create(TourApiService::class.java)
    }
}