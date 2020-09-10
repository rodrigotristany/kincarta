package com.rodrigotristany.kincarta.domain.repositories

import com.rodrigotristany.kincarta.domain.entities.Contact

interface ContactsRepository {
    suspend fun getContacts(): List<Contact>
}