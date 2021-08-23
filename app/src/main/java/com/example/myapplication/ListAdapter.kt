package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val data: ArrayList<Data>, private val OnClick : (data : Data, position : Int) -> Unit) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNumberText: TextView = itemView.findViewById(R.id.itemNumberText)
        val itemNameText: TextView = itemView.findViewById(R.id.itemNameText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        val myViewHolder = MyViewHolder(view)
        view.setOnClickListener{
            OnClick(data[myViewHolder.adapterPosition], myViewHolder.adapterPosition)
        }
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemNameText.text = data[position].itemNameText
        holder.itemNumberText.text = data[position].itemNumberText

    }

    override fun getItemCount(): Int = data.size

}