package com.rodrigotristany.kincarta.data.api

import com.rodrigotristany.kincarta.data.models.ContactModel
import io.reactivex.Single
import retrofit2.http.GET

interface ContactsApi {
    @GET("contacts.json")
    fun getContacts(): Single<List<ContactModel>>
}