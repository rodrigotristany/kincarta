package com.rodrigotristany.kincarta.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.rodrigotristany.kincarta.domain.entities.Address

data class AddressModel (
    @SerializedName("street")
    @Expose
    val street : String?,
    @SerializedName("city")
    @Expose
    val city : String?,
    @SerializedName("state")
    @Expose
    val state : String?,
    @SerializedName("country")
    @Expose
    val country : String?,
    @SerializedName("zipCode")
    @Expose
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