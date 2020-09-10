package com.rodrigotristany.kincarta.domain.usecases

import com.rodrigotristany.kincarta.data.mapper.ApiErrorMapper
import com.rodrigotristany.kincarta.domain.entities.Contact
import com.rodrigotristany.kincarta.domain.repositories.ContactsRepository
import com.rodrigotristany.kincarta.domain.usecases.base.UseCase
import javax.inject.Inject

class GetContactsUseCase
@Inject constructor(private val contactsRepository: ContactsRepository,
                    errorHandler: ApiErrorMapper) : UseCase<List<Contact>>(errorHandler){
    override suspend fun executeOnBackground(): List<Contact> = contactsRepository.getContacts()
}