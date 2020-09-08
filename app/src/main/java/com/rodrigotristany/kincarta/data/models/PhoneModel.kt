package com.rodrigotristany.kincarta.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.rodrigotristany.kincarta.domain.entities.Phone

data class PhoneModel(
    @SerializedName("work")
    @Expose
    val work : String?,
    @SerializedName("home")
    @Expose
    val home : String?,
    @SerializedName("mobile")
    @Expose
    val mobile : String?
) {
    fun toEntity() = Phone(
        work,
        home,
        mobile
    )
}