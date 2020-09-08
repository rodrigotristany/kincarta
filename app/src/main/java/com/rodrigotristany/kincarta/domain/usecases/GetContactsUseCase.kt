package com.rodrigotristany.kincarta.domain.usecases

import com.rodrigotristany.kincarta.data.mapper.ApiErrorMapper
import com.rodrigotristany.kincarta.domain.entities.Contact
import com.rodrigotristany.kincarta.domain.repositories.ContactsRepository
import com.rodrigotristany.kincarta.domain.usecases.base.UseCase
import javax.inject.Inject

class GetContactsUseCase
@Inject constructor(private val contactsRepository: ContactsRepository,
                    errorHandler: ApiErrorMapper) : UseCase<MutableList<Contact>>(errorHandler){
    override suspend fun executeOnBackground(): MutableList<Contact> {
        var contactsModel = contactsRepository.getContacts()
        return contactsModel.sortedBy { it.name }.sortedBy { !it.isFavorite }.toMutableList()
    }
}