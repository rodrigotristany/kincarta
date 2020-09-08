package com.rodrigotristany.kincarta.data.api

import com.rodrigotristany.kincarta.domain.entities.Contact
import com.rodrigotristany.kincarta.domain.repositories.ContactsRepository
import javax.inject.Inject

class ContactsProvider @Inject constructor(
    private val contactsApi: ContactsApi) : ContactsRepository {

    override suspend fun getContacts(): MutableList<Contact> {
        var contactsModel = contactsApi.getContactsAsync()
        return contactsModel.map { contactModel -> contactModel.toEntity() }.toMutableList()
    }
}