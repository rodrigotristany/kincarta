package com.rodrigotristany.kincarta.presentation.contactdetail.di

import com.rodrigotristany.kincarta.core.di.scopes.ActivityScope
import com.rodrigotristany.kincarta.presentation.contactdetail.ContactDetailActivity
import com.rodrigotristany.kincarta.presentation.contactdetail.ContactDetailFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface ContactDetailComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ContactDetailComponent
    }

    fun inject(activity: ContactDetailActivity)
    fun inject(fragment: ContactDetailFragment)
}