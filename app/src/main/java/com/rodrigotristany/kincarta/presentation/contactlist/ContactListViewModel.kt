package com.rodrigotristany.kincarta.presentation.contactlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rodrigotristany.kincarta.domain.entities.Contact
import com.rodrigotristany.kincarta.domain.models.ErrorModel
import com.rodrigotristany.kincarta.domain.usecases.GetContactsUseCase
import javax.inject.Inject

class ContactListViewModel
@Inject constructor(
    private val getContactsUseCase: GetContactsUseCase) : ViewModel() {

    val listContacts: MutableLiveData<List<Contact>> by lazy { MutableLiveData<List<Contact>>() }
    val error : MutableLiveData<ErrorModel> by lazy { MutableLiveData<ErrorModel>() }

    init {
        getContactsUseCase.execute {
            onComplete {
                listContacts.value = it
            }

            onError { throwable ->
                error.value=throwable
            }

            onCancel {}
        }
    }

    override fun onCleared() {
        super.onCleared()
        getContactsUseCase.unsubscribe()
    }
}