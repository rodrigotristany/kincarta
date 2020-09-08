package com.rodrigotristany.kincarta.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.rodrigotristany.kincarta.domain.entities.Contact

data class ContactModel(
    @SerializedName("name")
    @Expose
    val name : String?,
    @SerializedName("id")
    @Expose
    val id : Int,
    @SerializedName("companyName")
    @Expose
    val companyName : String?,
    @SerializedName("isFavorite")
    @Expose
    val isFavorite : Boolean,
    @SerializedName("smallImageURL")
    @Expose
    val smallImageURL : String?,
    @SerializedName("largeImageURL")
    @Expose
    val largeImageURL : String?,
    @SerializedName("emailAddress")
    @Expose
    val emailAddress : String?,
    @SerializedName("birthdate")
    @Expose
    val birthDate : String?,
    @SerializedName("phone")
    @Expose
    val phone : PhoneModel,
    @SerializedName("address")
    @Expose
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