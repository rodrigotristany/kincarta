package com.rodrigotristany.kincarta.domain.repositories

import com.rodrigotristany.kincarta.domain.entities.Contact
import io.reactivex.Single

interface ContactsRepository {
    fun getContacts(): Single<List<Contact>>
}