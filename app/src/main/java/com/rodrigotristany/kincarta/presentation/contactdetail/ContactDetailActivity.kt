package com.rodrigotristany.kincarta.presentation.contactdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigotristany.kincarta.core.App
import com.rodrigotristany.kincarta.R
import com.rodrigotristany.kincarta.presentation.contactdetail.di.ContactDetailComponent
import com.rodrigotristany.kincarta.presentation.contactlist.di.ContactListComponent

class ContactDetailActivity : AppCompatActivity() {

    lateinit var contactDetailComponent: ContactDetailComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        contactDetailComponent = (application as App)
            .appComponent
            .contactDetailComponent()
            .create()
        contactDetailComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ContactDetailFragment.newInstance())
                .commitNow()
        }
    }
}

