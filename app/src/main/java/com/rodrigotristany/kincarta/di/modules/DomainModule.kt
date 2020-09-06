package com.rodrigotristany.kincarta.di.modules

import com.rodrigotristany.kincarta.domain.repositories.ContactsRepository
import com.rodrigotristany.kincarta.domain.usecases.GetContactsUseCase
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class DomainModule {
    @Provides
    @Singleton
    @Named("ioScheduler")
    internal fun provideIoScheduler() = Schedulers.io()

    @Provides
    @Singleton
    @Named("mainThreadScheduler")
    internal fun provideMainThreadScheduler() = AndroidSchedulers.mainThread()

    @Provides
    internal fun provideGetLaptopsUseCase(
        contactsRepository: ContactsRepository,
        @Named("ioScheduler") ioScheduler: Scheduler,
        @Named("mainThreadScheduler") mainThreadScheduler: Scheduler): GetContactsUseCase =
        GetContactsUseCase(contactsRepository, ioScheduler, mainThreadScheduler)

}