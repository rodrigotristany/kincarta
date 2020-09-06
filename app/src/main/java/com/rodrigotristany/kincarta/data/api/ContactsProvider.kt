package com.rodrigotristany.kincarta.data.api

import com.rodrigotristany.kincarta.domain.entities.Contact
import com.rodrigotristany.kincarta.domain.repositories.ContactsRepository
import io.reactivex.Single
import javax.inject.Inject

class ContactsProvider @Inject constructor(private val contactsApi: ContactsApi) : ContactsRepository {
    override fun getContacts(): Single<List<Contact>> {
        var contactsModel = contactsApi.getContacts()
        var contacts = listOf<Contact>()
        contactsModel
            .doOnSuccess { contacts = it.map { contactModel -> contactModel.toEntity() } }
            .doOnError { error -> throw error }
        return Single.just(contacts)
    }
}