package com.mehmetalivargun.quotes.ui.home

import com.mehmetalivargun.domain.model.DailyImage

class HomeViewState(
    private val imageData:List<DailyImage>
) {
    fun getItems(): List<DailyImage>{
        return imageData
    }

}