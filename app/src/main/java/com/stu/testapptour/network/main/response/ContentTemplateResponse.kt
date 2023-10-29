package com.stu.testapptour.network.main.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.DirectionType
import com.stu.testapptour.features.home.domain.entity.ObjectType
import com.stu.testapptour.features.home.domain.entity.SizeType
import com.stu.testapptour.features.home.domain.entity.home.ContentTemplate

data class ContentTemplateResponse(
    @SerializedName("card")
    val card: String,
    @SerializedName("object")
    val `object`: String,
    @SerializedName("size")
    val size: String,
    @SerializedName("direction")
    val direction: String
) {
    fun toContentTemplate() : ContentTemplate {
        return ContentTemplate(
            card = when(card) {
                "vertical" -> DirectionType.VERTICAL
                "horizontal" -> DirectionType.HORIZONTAL
                else -> DirectionType.VERTICAL
            },
            objectType = when(`object`) {
                "object" -> ObjectType.OBJECT
                "room" -> ObjectType.ROOM
                "blog" -> ObjectType.BLOG
                "tour" -> ObjectType.TOUR
                else -> ObjectType.OBJECT
            },
            size = when(size) {
                "small" -> SizeType.SMALL
                "medium" -> SizeType.MEDIUM
                "large" -> SizeType.LARGE
                else -> SizeType.MEDIUM
            },
            direction = when(direction) {
                "vertical" -> DirectionType.VERTICAL
                "horizontal" -> DirectionType.HORIZONTAL
                else -> DirectionType.VERTICAL
            }
        )
    }
}
