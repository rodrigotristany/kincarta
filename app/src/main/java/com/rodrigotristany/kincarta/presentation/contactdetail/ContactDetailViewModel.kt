package com.rodrigotristany.kincarta.presentation.contactdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rodrigotristany.kincarta.domain.entities.Contact
import com.rodrigotristany.kincarta.domain.models.ErrorModel
import com.rodrigotristany.kincarta.presentation.contactdetail.models.ContactInfo
import javax.inject.Inject

class ContactDetailViewModel
    @Inject constructor(): ViewModel() {

    val contactInfo: MutableLiveData<ArrayList<ContactInfo>> by lazy { MutableLiveData<ArrayList<ContactInfo>>() }
    val contact : MutableLiveData<Contact> by lazy { MutableLiveData<Contact>() }
}