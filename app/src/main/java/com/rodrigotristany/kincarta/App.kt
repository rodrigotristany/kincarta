package com.rodrigotristany.kincarta

import android.app.Application
import com.rodrigotristany.kincarta.di.components.ApplicationComponent
import com.rodrigotristany.kincarta.di.components.DaggerApplicationComponent
import com.rodrigotristany.kincarta.di.modules.ApplicationModule

class App: Application() {
    private val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        initInjector()
    }

    private fun initInjector() {
        applicationComponent.inject(this)
    }
}