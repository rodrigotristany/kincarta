package com.rodrigotristany.kincarta.domain.usecases

import com.rodrigotristany.kincarta.domain.entities.Contact
import com.rodrigotristany.kincarta.domain.repositories.ContactsRepository
import com.rodrigotristany.kincarta.domain.usecases.base.UseCase
import io.reactivex.Scheduler

class GetContactsUseCase(private val contactsRepository: ContactsRepository,
                         subscribeScheduler: Scheduler,
                         postExecutionScheduler: Scheduler) : UseCase<List<Contact>, Unit>(subscribeScheduler, postExecutionScheduler){
    override fun buildUseCaseSingle(params: Unit?) =  contactsRepository.getContacts()
}