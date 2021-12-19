package com.mehmetalivargun.core.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehmetalivargun.core.data.ApiResult
import com.mehmetalivargun.core.domain.ErrorPageViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import mehmetalivargun.core.extension.onError

abstract class BaseViewModel :  ViewModel() {
    private val error = MutableLiveData<ErrorPageViewState>()
    val errorData: LiveData<ErrorPageViewState> by ::error

    fun <T> sendRequest(
        callFunc: () -> Flow<ApiResult<T>>,
        retryFunc: () -> Unit,
        errorFunc: (throwable: Throwable) -> Unit = { throwable -> publishError(throwable, retryFunc) }
    ): Flow<ApiResult<T>> {
        return callFunc().apply {
            onError { errorFunc(it) }.launch()
        }
    }

    open fun publishError(throwable: Throwable, retryFunc: () -> Unit) {
        error.value = ErrorPageViewState(throwable = throwable, retryFunc = retryFunc)
    }

    fun <T> Flow<ApiResult<T>>.launch() {
        launchIn(viewModelScope)
    }
}