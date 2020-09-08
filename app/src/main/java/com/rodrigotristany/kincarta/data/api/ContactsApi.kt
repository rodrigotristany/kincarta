package com.rodrigotristany.kincarta.data.api

import com.rodrigotristany.kincarta.data.models.ContactModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ContactsApi {
    @GET("contacts.json")
    suspend fun getContactsAsync(): List<ContactModel>
}