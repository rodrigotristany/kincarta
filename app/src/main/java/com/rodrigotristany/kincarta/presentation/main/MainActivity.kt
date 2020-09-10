package com.rodrigotristany.kincarta.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigotristany.kincarta.core.App
import com.rodrigotristany.kincarta.R
import com.rodrigotristany.kincarta.presentation.main.di.MainComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (application as App)
            .appComponent
            .contactsListComponent()
            .create()
        mainComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
    }
}