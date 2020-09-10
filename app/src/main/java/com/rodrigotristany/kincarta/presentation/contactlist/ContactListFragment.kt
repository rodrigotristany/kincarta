package com.rodrigotristany.kincarta.presentation.contactlist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.rodrigotristany.kincarta.R
import com.rodrigotristany.kincarta.domain.entities.Contact
import com.rodrigotristany.kincarta.presentation.contactdetail.models.ContactDetailModel
import com.rodrigotristany.kincarta.presentation.main.MainActivity
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
        var contactDetailModel = ContactDetailModel.createFromContact(item)
        val bundle = bundleOf(
            "contactArg" to item,
            "contactInfoArg" to contactDetailModel
        )
        Navigation.createNavigateOnClickListener(R.id.next_action, bundle).onClick(this.view)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        with(viewModel) {
            listContacts.observe(viewLifecycleOwner, { initView(it) })
            error.observe(viewLifecycleOwner, { message.text = "${it?.message}" })
        }
    }

    private fun setRecyclerView() {
        rv_contacts_list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            context, RecyclerView.VERTICAL, false)
        rv_contacts_list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        rv_contacts_list.adapter = adapter
    }

    private fun initView(it: List<Contact>) {
        if (it.isNotEmpty()) {
            fillRecyclerView(it)
            message.text = ""
        }
        else{
            message.text = context?.getString(R.string.empty_list)
        }
    }

    private fun fillRecyclerView(it: List<Contact>) {
        adapter.clear()
        adapter.add(it.sortedBy { it.name }.sortedBy { !it.isFavorite }.toMutableList())
    }
}