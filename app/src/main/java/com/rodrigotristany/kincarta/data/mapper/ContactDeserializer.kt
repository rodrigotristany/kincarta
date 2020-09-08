package com.rodrigotristany.kincarta.data.mapper

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.rodrigotristany.kincarta.data.models.AddressModel
import com.rodrigotristany.kincarta.data.models.ContactModel
import com.rodrigotristany.kincarta.data.models.PhoneModel
import java.lang.reflect.Type

class ContactDeserializer : JsonDeserializer<ContactModel> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): ContactModel {
        var jsonObject = json?.asJsonObject
        return ContactModel(
            jsonObject?.get("name")?.asString ?: "",
            jsonObject?.get("id")?.asInt ?: 0,
            jsonObject?.get("companyName")?.asString ?: "",
            jsonObject?.get("isFavorite")?.asBoolean ?: false,
            jsonObject?.get("smallImageURL")?.asString ?: "",
            jsonObject?.get("largeImageURL")?.asString ?: "",
            jsonObject?.get("emailAddress")?.asString ?: "",
            jsonObject?.get("birthDate")?.asString ?: "",
            deserializePhoneModel(jsonObject?.get("phone")),
            deserializeAddressModel(jsonObject?.get("address")),
        )
    }

    private fun deserializePhoneModel(json: JsonElement?) =
        PhoneModel(
            json?.asJsonObject?.get("work")?.asString ?: "",
            json?.asJsonObject?.get("home")?.asString ?: "",
            json?.asJsonObject?.get("mobile")?.asString ?: "",
        )

    private fun deserializeAddressModel(json: JsonElement?) =
        AddressModel(
            json?.asJsonObject?.get("street")?.asString ?: "",
            json?.asJsonObject?.get("city")?.asString ?: "",
            json?.asJsonObject?.get("state")?.asString ?: "",
            json?.asJsonObject?.get("country")?.asString ?: "",
            json?.asJsonObject?.get("zipCode")?.asInt ?: 0,
        )
}