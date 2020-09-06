package com.rodrigotristany.kincarta.data.models

import com.google.gson.annotations.SerializedName
import com.rodrigotristany.kincarta.domain.entities.Address

data class AddressModel (
    @SerializedName("street")
    val street : String,
    @SerializedName("city")
    val city : String,
    @SerializedName("state")
    val state : String,
    @SerializedName("country")
    val country : String,
    @SerializedName("zipCode")
    val zipCode : Int
) {
    fun toEntity() = Address(
        street,
        city,
        state,
        country,
        zipCode
    )
}