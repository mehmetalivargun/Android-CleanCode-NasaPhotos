package com.mehmetalivargun.quotes.ui.imagedetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.mehmetalivargun.core.ui.BaseViewModel
import javax.inject.Inject

class ImageDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel() {
    private var link :String = ""
    private val viewState = MutableLiveData<String>()
    val viewStateData: LiveData<String> by ::viewState

    init {
       savedStateHandle.get<String>("imageUrl")?.let {
            viewState.value=it
       }
    }
}