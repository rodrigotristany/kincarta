package com.rodrigotristany.kincarta.core.di.modules

import com.rodrigotristany.kincarta.data.mapper.ApiErrorMapper
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
    fun provideErrorHandler(): ApiErrorMapper {
        return ApiErrorMapper()
    }

    @Provides
    @Singleton
    fun provideGetContactsUseCase(contactsRepository: ContactsRepository,
                                  errorHandler: ApiErrorMapper): GetContactsUseCase =
        GetContactsUseCase(contactsRepository, errorHandler)

}