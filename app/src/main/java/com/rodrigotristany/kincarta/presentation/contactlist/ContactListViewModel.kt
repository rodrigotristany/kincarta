package com.rodrigotristany.kincarta.presentation.contactlist

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.rodrigotristany.kincarta.domain.entities.Contact
import com.rodrigotristany.kincarta.domain.models.ErrorModel
import com.rodrigotristany.kincarta.domain.usecases.GetContactsUseCase
import com.rodrigotristany.kincarta.presentation.contactdetail.models.ContactInfo
import javax.inject.Inject

class ContactListViewModel
@Inject constructor(
    private val getContactsUseCase: GetContactsUseCase) : ViewModel() {

    val listContacts: MutableLiveData<List<Contact>> by lazy { MutableLiveData<List<Contact>>() }
    val error : MutableLiveData<ErrorModel> by lazy { MutableLiveData<ErrorModel>() }
    val contactInfo: MutableLiveData<ArrayList<ContactInfo>> by lazy { MutableLiveData<ArrayList<ContactInfo>>() }
    val contact : MutableLiveData<Contact> by lazy { MutableLiveData<Contact>() }
    val isFavorite : MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    val mediatorLiveData = MediatorLiveData<Contact>().apply {
        this.addSource(contact) { listContacts }
    }

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
