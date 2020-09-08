package com.rodrigotristany.kincarta.data.mapper

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.rodrigotristany.kincarta.data.models.AddressModel
import java.lang.reflect.Type

class AddressDeserializer : JsonDeserializer<AddressModel> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): AddressModel {
        var jsonObject = json?.asJsonObject
        return AddressModel(
            jsonObject?.get("street")?.asString ?: "",
            jsonObject?.get("city")?.asString ?: "",
            jsonObject?.get("state")?.asString ?: "",
            jsonObject?.get("country")?.asString ?: "",
            jsonObject?.get("zipCode")?.asInt ?: 0,
        )
    }
}