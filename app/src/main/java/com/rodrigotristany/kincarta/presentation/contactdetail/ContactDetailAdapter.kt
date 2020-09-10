package com.rodrigotristany.kincarta.presentation.contactdetail

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rodrigotristany.kincarta.R
import com.rodrigotristany.kincarta.core.extensions.inflate
import com.rodrigotristany.kincarta.domain.entities.Contact
import com.rodrigotristany.kincarta.presentation.contactdetail.models.ContactDetailModel
import com.rodrigotristany.kincarta.presentation.contactdetail.models.ContactInfo
import kotlinx.android.synthetic.main.item_contacts_detail.view.*
import kotlinx.android.synthetic.main.item_contacts_detail_address.view.*
import kotlinx.android.synthetic.main.item_contacts_detail_phone.view.*

class ContactDetailAdapter(private val contactInfoList: ArrayList<ContactInfo>):
    RecyclerView.Adapter<ContactDetailAdapter.BaseViewHolder>() {

    abstract  class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(contactInfo: ContactInfo)
    }

    class PhoneViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val title = itemView.titlePhone
        private val value = itemView.valuePhone
        private val type = itemView.typePhone

        override fun bind(contactInfo: ContactInfo) {
            title.text = contactInfo.title
            value.text = contactInfo.value
            type.text = contactInfo.secondaryValue
        }
    }

    class AddressViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val title = itemView.titleAddress
        private val valueTop = itemView.value_top
        private val valueBottom = itemView.value_bottom

        override fun bind(contactInfo: ContactInfo) {
            title.text = contactInfo.title
            valueTop.text = contactInfo.value
            valueBottom.text = contactInfo.secondaryValue
        }
    }

    class DetailViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val title = itemView.title
        private val value = itemView.value

        override fun bind(contactInfo: ContactInfo) {
            title.text = contactInfo.title
            value.text = contactInfo.value
        }
    }

    override fun getItemCount() = contactInfoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType) {
            ContactDetailModel.ADDRESS -> AddressViewHolder(parent.inflate(R.layout.item_contacts_detail_address))
            ContactDetailModel.PHONE -> PhoneViewHolder(parent.inflate(R.layout.item_contacts_detail_phone))
            else -> DetailViewHolder(parent.inflate(R.layout.item_contacts_detail))
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(contactInfoList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return contactInfoList[position].type
    }

    fun add(list: MutableList<ContactInfo>) {
        contactInfoList.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        contactInfoList.clear()
        notifyDataSetChanged()
    }
}