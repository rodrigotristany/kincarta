package com.rodrigotristany.kincarta.presentation.contactlist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.rodrigotristany.kincarta.R
import com.rodrigotristany.kincarta.domain.entities.Contact
import kotlinx.android.synthetic.main.fragment_contact_list.*
import javax.inject.Inject

class ContactListFragment : Fragment() {

    companion object {
        fun newInstance() = ContactListFragment()
    }

    @Inject
    lateinit var viewModel: ContactListViewModel

    private val adapter : ContactListAdapter by lazy { ContactListAdapter(mutableListOf()){ item -> onItemClicked(item) } }

    private fun onItemClicked(item: Contact) {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as ContactListActivity).contactListComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            listContacts.observe(viewLifecycleOwner, Observer { initView(it) })
            error.observe(viewLifecycleOwner, Observer { message.text = "${it?.message}" })
        }
    }

    private fun initView(it: MutableList<Contact>) {
        rv_contacts_list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            context, RecyclerView.VERTICAL, false)
        rv_contacts_list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        rv_contacts_list.adapter = adapter
        if (it.isNotEmpty()) {
            adapter.clear()
            adapter.add(it)
            message.text = ""
        }
        else{
            message.text = context?.getString(R.string.empty_list)
        }
    }
}