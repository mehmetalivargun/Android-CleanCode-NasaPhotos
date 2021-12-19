package com.mehmetalivargun.quotes.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.mehmetalivargun.domain.model.DailyImage
import com.mehmetalivargun.quotes.databinding.ItemImageBinding

class ImagesAdapter(  private val callback: ImagesAdapterCallback):ListAdapter<DailyImage,ImageViewHolder>(
    AdapterItemDiffCallback()
) {

    private class AdapterItemDiffCallback : DiffUtil.ItemCallback<DailyImage>() {

        override fun areItemsTheSame(oldItem: DailyImage, newItem: DailyImage): Boolean {
            return oldItem.date == newItem.date
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: DailyImage, newItem: DailyImage): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layout = LayoutInflater.from(parent.context)
        return ImageViewHolder(binding = ItemImageBinding.inflate(layout,parent,false), callback =callback )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}