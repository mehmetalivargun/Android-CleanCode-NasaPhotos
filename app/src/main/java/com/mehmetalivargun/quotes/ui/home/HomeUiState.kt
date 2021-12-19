package com.mehmetalivargun.quotes.ui.home

import com.mehmetalivargun.core.data.ApiResult

class HomeUiState(val apiResult : ApiResult<*>) {
    fun isLoading():Boolean{
        return apiResult is ApiResult.Loading
    }
    fun isSuccess():Boolean{
        return apiResult is ApiResult.Success
    }
}