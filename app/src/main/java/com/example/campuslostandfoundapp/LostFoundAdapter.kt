package com.glitchguild.campuslostandfound

import LostFoundItem
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.glitchguild.campuslostandfound.databinding.ItemLostFoundBinding

class LostFoundAdapter(
    private val items: List<LostFoundItem>
) : RecyclerView.Adapter<LostFoundAdapter.VH>() {

    inner class VH(val binding: ItemLostFoundBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemLostFoundBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]

        holder.binding.tvItemType.text = item.type
        holder.binding.tvItemName.text = item.name
        holder.binding.tvItemDescription.text = item.description

        Log.d("Adapter", "Loading image: ${item.imageUri}")

        if (!item.imageUri.isNullOrEmpty()) {
            Glide.with(holder.itemView.context)
                .load(Uri.parse(item.imageUri))
                .centerCrop()
                .into(holder.binding.ivItemImage)
        } else {
            holder.binding.ivItemImage.setImageResource(android.R.color.darker_gray)
        }
    }

    override fun getItemCount(): Int = items.size
}
