package com.rodrigotristany.kincarta.di.modules

import com.rodrigotristany.kincarta.presentation.contacdetail.ContactDetailViewModel
import com.rodrigotristany.kincarta.presentation.contactlist.ContactListViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresentationModule {
    @Singleton
    @Provides
    fun provideContactDetailViewModel() : ContactDetailViewModel {
        return ContactDetailViewModel()
    }

    @Singleton
    @Provides
    fun provideContactListViewModel() : ContactListViewModel {
        return ContactListViewModel()
    }
}