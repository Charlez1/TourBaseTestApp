package com.stu.testapptour.features.home.domain.entity.room

import com.google.gson.annotations.SerializedName

data class Price(
    val factPrice: Int,
    val price: Int,
    //val discount: Any?, // todo dont know type
    val currency: String,
    val typePrice: String
)
