package com.rodrigotristany.kincarta.presentation.contactdetail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.rodrigotristany.kincarta.R
import com.rodrigotristany.kincarta.domain.entities.Contact
import com.rodrigotristany.kincarta.presentation.contactdetail.models.ContactInfo
import com.rodrigotristany.kincarta.presentation.contactlist.ContactListActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_contact_detail.*
import java.util.ArrayList
import javax.inject.Inject

class ContactDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ContactDetailFragment()
    }

    @Inject
    lateinit var viewModel: ContactDetailViewModel

    private val adapter : ContactDetailAdapter by lazy { ContactDetailAdapter(arrayListOf()) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as ContactListActivity).contactListComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            contact.observe(viewLifecycleOwner, { setHeaderView(it) })
            contactInfo.observe(viewLifecycleOwner, { setContactInfoView(it) })
        }
    }

    private fun setHeaderView(it: Contact) {
        Picasso.get()
            .load(it.largeImageURL)
            .placeholder(R.mipmap.user_large)
            .error(R.mipmap.user_large)
            .into(profile_image)
        contact_name.text = it.name
        contact_company.text = it.companyName
    }

    private fun setContactInfoView(it: ArrayList<ContactInfo>) {
        rv_contact_detail.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            context, RecyclerView.VERTICAL, false)
        rv_contact_detail.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        rv_contact_detail.adapter = adapter
        if (it.isNotEmpty()) {
            adapter.clear()
            adapter.add(it)
        }
    }
}