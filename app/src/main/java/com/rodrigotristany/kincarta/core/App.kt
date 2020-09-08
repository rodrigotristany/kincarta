package com.rodrigotristany.kincarta.core

import android.app.Application
import com.rodrigotristany.kincarta.core.di.components.ApplicationComponent
import com.rodrigotristany.kincarta.core.di.components.DaggerApplicationComponent

class App: Application() {
    val appComponent: ApplicationComponent by lazy {
        initializeComponent()
    }

    private  fun initializeComponent(): ApplicationComponent {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }
}