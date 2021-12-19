package com.mehmetalivargun.quotes.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.mehmetalivargun.domain.model.DailyImage
import com.mehmetalivargun.quotes.databinding.ItemImageBinding

class ImageViewHolder(
    private val binding : ItemImageBinding,
    private val callback: ImagesAdapterCallback
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data:DailyImage){
        binding.dailyImage=data
        binding.root.setOnClickListener{
            callback.onItemClick(data)
        }
    }
}