package com.rodrigotristany.kincarta.presentation.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigotristany.kincarta.R

class ContactListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ContactListFragment.newInstance())
                    .commitNow()
        }
    }
}