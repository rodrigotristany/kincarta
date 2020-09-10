package com.rodrigotristany.kincarta.core.di.components

import android.content.Context
import com.rodrigotristany.kincarta.core.di.modules.*
import com.rodrigotristany.kincarta.presentation.contactdetail.di.ContactDetailComponent
import com.rodrigotristany.kincarta.presentation.main.di.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DomainModule::class,
    DataModule::class])
interface ApplicationComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun contactsListComponent(): MainComponent.Factory
    fun contactDetailComponent(): ContactDetailComponent.Factory
}