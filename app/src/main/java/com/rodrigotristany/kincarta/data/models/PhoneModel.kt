package com.rodrigotristany.kincarta.data.models

import com.google.gson.annotations.SerializedName
import com.rodrigotristany.kincarta.domain.entities.Phone

data class PhoneModel(
    @SerializedName("work")
    val work : String,
    @SerializedName("home")
    val home : String,
    @SerializedName("mobile")
    val mobile : String
) {
    fun toEntity() = Phone(
        work,
        home,
        mobile
    )
}