package com.mehmetalivargun.quotes.ui.home.adapter

import com.mehmetalivargun.domain.model.DailyImage

interface ImagesAdapterCallback {
    fun onItemClick(image:DailyImage)
}