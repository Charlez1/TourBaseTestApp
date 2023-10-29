package com.stu.testapptour.network.room.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.room.Price

data class PriceResponse(
    @SerializedName("factPrice")
    val factPrice: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("discount")
    val discount: Any?, // todo dont know type
    @SerializedName("currency")
    val currency: String,
    @SerializedName("typePrice")
    val typePrice: String
) {
    fun toPrice() : Price {
        return Price(
            factPrice = factPrice,
            price = price,
            currency = currency,
            typePrice = typePrice
        )
    }
}