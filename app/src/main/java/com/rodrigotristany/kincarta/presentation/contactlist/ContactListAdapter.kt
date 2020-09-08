package com.rodrigotristany.kincarta.presentation.contactlist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rodrigotristany.kincarta.R
import com.rodrigotristany.kincarta.domain.entities.Contact
import com.rodrigotristany.kincarta.core.extensions.inflate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_contacts_list.view.*

class ContactListAdapter(private val contacts: MutableList<Contact>, val listener: (Contact) -> Unit):
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val contactName = itemView.contact_name
        private val contactInfo = itemView.contact_info
        private val isFavorite = itemView.is_favorite
        private val contactThumb = itemView.thumbnail

        fun bind(contact: Contact) {
            contactName.text = contact.name
            contactInfo.text = contact.companyName
            isFavorite.visibility = if (contact.isFavorite) View.VISIBLE else View.INVISIBLE
            Picasso.get()
                .load(contact.smallImageURL)
                .placeholder(R.mipmap.user_small)
                .error(R.mipmap.user_small)
                .into(contactThumb)
        }
    }

    override fun getItemCount() = contacts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_contacts_list))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contacts[position])
        holder.itemView.setOnClickListener { listener(contacts[position]) }
    }

    fun add(list: MutableList<Contact>) {
        contacts.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        contacts.clear()
        notifyDataSetChanged()
    }
}