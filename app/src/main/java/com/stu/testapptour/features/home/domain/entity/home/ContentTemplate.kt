package com.stu.testapptour.features.home.domain.entity.home

import com.stu.testapptour.features.home.domain.entity.DirectionType
import com.stu.testapptour.features.home.domain.entity.ObjectType
import com.stu.testapptour.features.home.domain.entity.SizeType

data class ContentTemplate(
    val card: DirectionType,
    val objectType: ObjectType,
    val size: SizeType,
    val direction: DirectionType
)
