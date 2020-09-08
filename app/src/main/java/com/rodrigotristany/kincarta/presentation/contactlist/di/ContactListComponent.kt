package com.rodrigotristany.kincarta.presentation.contactlist.di

import com.rodrigotristany.kincarta.core.di.scopes.ActivityScope
import com.rodrigotristany.kincarta.presentation.contactlist.ContactListActivity
import com.rodrigotristany.kincarta.presentation.contactlist.ContactListFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface ContactListComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ContactListComponent
    }

    fun inject(activity: ContactListActivity)
    fun inject(fragment: ContactListFragment)
}