package com.example.atomic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.atomic.R
import com.example.atomic.model.Sport

class SportAdapter(private val cryptocurrency: MutableList<Sport>) :
    RecyclerView.Adapter<SportAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflating list data from list_item to view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    // Binding cryptocurrency list to ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cryptocurrency[position])
    }

    override fun getItemCount() = cryptocurrency.size

    public fun clearItems() = cryptocurrency.clear()

    // Iterating ViewHolder and loading it's
    // content to our Image and Text ViewsT
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(index: Sport) {
            // Here, we are using Glide library to
            // load the image into ImageView

            itemView.findViewById<TextView>(R.id.title).text = index.name
            itemView.findViewById<TextView>(R.id.desc).text = index.description
        }
    }
}