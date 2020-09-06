package com.rodrigotristany.kincarta.data.models

import com.google.gson.annotations.SerializedName
import com.rodrigotristany.kincarta.domain.entities.Contact

data class ContactModel(
    @SerializedName("name")
    val name : String,
    @SerializedName("id")
    val id : Int,
    @SerializedName("companyName")
    val companyName : String,
    @SerializedName("isFavorite")
    val isFavorite : Boolean,
    @SerializedName("smallImageURL")
    val smallImageURL : String,
    @SerializedName("largeImageURL")
    val largeImageURL : String,
    @SerializedName("emailAddress")
    val emailAddress : String,
    @SerializedName("birthdate")
    val birthDate : String,
    @SerializedName("phone")
    val phone : PhoneModel,
    @SerializedName("address")
    val address : AddressModel
) {
    fun toEntity() = Contact(
            name,
            id,
            companyName,
            isFavorite,
            smallImageURL,
            largeImageURL,
            emailAddress,
            birthDate,
            phone.toEntity(),
            address.toEntity()
        )
}