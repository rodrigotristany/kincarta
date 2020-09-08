package com.rodrigotristany.kincarta.presentation.contactdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rodrigotristany.kincarta.domain.entities.Contact
import javax.inject.Inject

class ContactDetailViewModel
    @Inject constructor(): ViewModel() {
    val contact: MutableLiveData<Contact> by lazy {
        MutableLiveData<Contact>()
    }
}