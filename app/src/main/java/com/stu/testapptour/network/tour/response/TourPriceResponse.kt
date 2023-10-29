package com.stu.testapptour.network.tour.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.tour.TourPrice

data class TourPriceResponse(
    @SerializedName("factPrice") val factPrice: Int,
    @SerializedName("price") val price: Int,
    @SerializedName("currency") val currency: String,
    @SerializedName("typePrice") val typePrice: String
) {
    fun toTourPrice(): TourPrice {
        return TourPrice(
            factPrice = factPrice,
            price = price,
            currency = currency,
            typePrice = typePrice
        )
    }
}
