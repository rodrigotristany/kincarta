package com.rodrigotristany.kincarta.presentation.contactlist

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
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

//        val host: NavHostFragment = supportFragmentManager
//            .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return
//
//        val navController = host.navController
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            val dest: String = try {
//                resources.getResourceName(destination.id)
//            } catch (e: Resources.NotFoundException) {
//                destination.id.toString()
//            }
//
//            Toast.makeText(this, "Navigated to $dest",
//                Toast.LENGTH_SHORT).show()
//            Log.d("NavigationActivity", "Navigated to $dest")
//        }
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                    .replace(R.id.container, ContactListFragment.newInstance())
//                    .commitNow()
//        }
    }
}