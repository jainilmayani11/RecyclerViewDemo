package com.example.recyclerviewdemo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val contactList: ArrayList<ContactModel>) : RecyclerView.Adapter<ContactAdapter.ViewHolderClass>() {


    var onItemClick : ((ContactModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_row, parent, false)
        return ViewHolderClass(itemView)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        val currentItem = contactList[position]
        holder.rvImage.setImageResource(currentItem.img)
        holder.rvContact.text = currentItem.name
        holder.rvContactNumber.text = currentItem.number.toString()

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }


    class ViewHolderClass(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val rvImage : ImageView = itemView.findViewById(R.id.imageContact)
        val rvContact : TextView = itemView.findViewById(R.id.txtContact)
        val rvContactNumber : TextView = itemView.findViewById(R.id.txtContactNumber)

    }


}