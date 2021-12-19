package com.mehmetalivargun.core.data

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

abstract class BaseRepository {
    fun <T> callApi(block: suspend () -> T): Flow<ApiResult<T>> {
        Log.e("Test","apiCalled")
        return flow {
            emit(ApiResult.Success(block.invoke()) as ApiResult<T>)
        }
            .onStart { emit(ApiResult.Loading) }
            .catch { throwable -> emit(ApiResult.Error(throwable)) }
    }
}