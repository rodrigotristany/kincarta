package com.rodrigotristany.kincarta.di.components

import android.content.Context
import com.rodrigotristany.kincarta.App
import com.rodrigotristany.kincarta.data.api.ContactsApi
import com.rodrigotristany.kincarta.di.modules.ApplicationModule
import com.rodrigotristany.kincarta.di.modules.DataModule
import com.rodrigotristany.kincarta.di.modules.DomainModule
import com.rodrigotristany.kincarta.di.modules.PresentationModule
import com.rodrigotristany.kincarta.domain.repositories.ContactsRepository
import com.rodrigotristany.kincarta.domain.usecases.GetContactsUseCase
import com.rodrigotristany.kincarta.presentation.contacdetail.ContactDetailActivity
import com.rodrigotristany.kincarta.presentation.contacdetail.ContactDetailFragment
import com.rodrigotristany.kincarta.presentation.contacdetail.ContactDetailViewModel
import com.rodrigotristany.kincarta.presentation.contactlist.ContactListActivity
import com.rodrigotristany.kincarta.presentation.contactlist.ContactListFragment
import com.rodrigotristany.kincarta.presentation.contactlist.ContactListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    DomainModule::class,
    DataModule::class,
    PresentationModule::class])
interface ApplicationComponent {
    fun inject(app: App)
    fun inject(contactsListActivity: ContactListActivity)
    fun inject(contactsListFragment: ContactListFragment)
    fun inject(contactsDetailActivity: ContactDetailActivity)
    fun inject(contactDetailFragment: ContactDetailFragment)
    fun applicationContext(): Context
    fun contactsApi(): ContactsApi
    fun getContactsUseCase(): GetContactsUseCase
    fun contactsRepository(): ContactsRepository
    fun contactDetailViewModel() : ContactDetailViewModel
    fun contacListViewModel() : ContactListViewModel
}