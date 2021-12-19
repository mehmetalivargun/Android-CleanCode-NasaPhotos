package com.mehmetalivargun.quotes.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mehmetalivargun.core.ui.BaseViewModel
import com.mehmetalivargun.data.api.RestApi
import com.mehmetalivargun.domain.usecase.DailyImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mehmetalivargun.core.extension.onResultChanged
import mehmetalivargun.core.extension.onSuccess
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dailyImageUseCase: DailyImageUseCase,
    private val api:RestApi
):BaseViewModel() {

    private val viewState = MutableLiveData<HomeViewState>()
    val viewStateData: LiveData<HomeViewState> by ::viewState

    private val uiState = MutableLiveData<HomeUiState>()
    val uiStateData: LiveData<HomeUiState> by ::uiState


    internal fun getDailyImages(){

        sendRequest(
            callFunc ={dailyImageUseCase(Unit)},
            retryFunc = {getDailyImages()}
        ).onResultChanged {
            uiState.value=HomeUiState(it)
        }.onSuccess {
            viewState.value=HomeViewState(it)

        }.launch()
    }
}