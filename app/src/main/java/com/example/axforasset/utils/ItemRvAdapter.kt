package com.example.axforasset.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.axforasset.databinding.ItemCardBinding
import com.example.axforasset.models.Item
import kotlin.collections.ArrayList

class ItemRvAdapter(private val items : ArrayList<Item>, private val recyclerViewInterface : RecyclerViewInterface): RecyclerView.Adapter<ItemRvAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCardBinding, val recyclerViewInterface: RecyclerViewInterface): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                if(bindingAdapterPosition != RecyclerView.NO_POSITION) {
                    recyclerViewInterface.onItemClick(bindingAdapterPosition)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false), recyclerViewInterface)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : Item = items[position]
        holder.binding.apply {
            itemImg.setImageResource(item.image)
            itemTitle.text = item.title
            itemDesc.text = item.desc
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}