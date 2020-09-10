package com.rodrigotristany.kincarta.presentation.main.di

import com.rodrigotristany.kincarta.core.di.scopes.ActivityScope
import com.rodrigotristany.kincarta.presentation.contactdetail.ContactDetailFragment
import com.rodrigotristany.kincarta.presentation.main.MainActivity
import com.rodrigotristany.kincarta.presentation.contactlist.ContactListFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: ContactListFragment)
    fun inject(fragment: ContactDetailFragment)
}