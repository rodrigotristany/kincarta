package com.rodrigotristany.kincarta.presentation.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigotristany.kincarta.core.App
import com.rodrigotristany.kincarta.R
import com.rodrigotristany.kincarta.presentation.contactlist.di.ContactListComponent

class ContactListActivity : AppCompatActivity() {

    lateinit var contactListComponent: ContactListComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        contactListComponent = (application as App)
            .appComponent
            .contactsListComponent()
            .create()
        contactListComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ContactListFragment.newInstance())
                    .commitNow()
        }
    }
}