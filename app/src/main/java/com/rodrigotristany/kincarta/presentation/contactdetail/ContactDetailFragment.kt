package com.rodrigotristany.kincarta.presentation.contactdetail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rodrigotristany.kincarta.R
import com.rodrigotristany.kincarta.presentation.contactlist.ContactListActivity
import com.rodrigotristany.kincarta.presentation.contactlist.ContactListViewModel
import javax.inject.Inject

class ContactDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ContactDetailFragment()
    }

    @Inject
    lateinit var viewModel: ContactDetailViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as ContactDetailActivity).contactDetailComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_detail, container, false)
    }

}