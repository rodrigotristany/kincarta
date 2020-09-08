package com.rodrigotristany.kincarta.data.mapper

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.rodrigotristany.kincarta.data.models.PhoneModel
import java.lang.reflect.Type

class PhoneDeserializer : JsonDeserializer<PhoneModel> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): PhoneModel {
        var jsonObject = json?.asJsonObject;
        return PhoneModel(
            jsonObject?.get("work")?.asString ?: "",
            jsonObject?.get("home")?.asString ?: "",
            jsonObject?.get("mobile")?.asString ?: "",
        )
    }

}