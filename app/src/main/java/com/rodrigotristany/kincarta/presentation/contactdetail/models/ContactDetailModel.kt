package com.rodrigotristany.kincarta.presentation.contactdetail.models

import com.rodrigotristany.kincarta.domain.entities.Contact

class ContactDetailModel {
    companion object {
        const val PHONE = 1
        const val ADDRESS = 2
        const val DETAIL = 3

        fun createFromContact(item: Contact) : ContactDetailModel {
            var contactDetailModel = ContactDetailModel()

            if(!item.phone.home.isNullOrEmpty())
                contactDetailModel.modelList.add(
                    ContactInfo("PHONE:", item.phone.home, "Home", ContactDetailModel.PHONE))
            if(!item.phone.mobile.isNullOrEmpty())
                contactDetailModel.modelList.add(
                    ContactInfo("PHONE:", item.phone.mobile, "Mobile", ContactDetailModel.PHONE))
            if(!item.phone.work.isNullOrEmpty())
                contactDetailModel.modelList.add(
                    ContactInfo("PHONE:", item.phone.work, "Work", ContactDetailModel.PHONE))

            contactDetailModel.modelList.add(
                ContactInfo("ADDRESS:", item.address.street, item.address.parseCity, ContactDetailModel.ADDRESS))

            if(!item.birthDate.isNullOrEmpty())
                contactDetailModel.modelList.add(
                    ContactInfo("BIRTHDATE:", item.birthDate, "", ContactDetailModel.DETAIL))

            if(!item.emailAddress.isNullOrEmpty())
                contactDetailModel.modelList.add(
                    ContactInfo("EMAIL:", item.birthDate, "", ContactDetailModel.DETAIL))

            return contactDetailModel
        }
    }

    var modelList: ArrayList<ContactInfo> = arrayListOf()

}