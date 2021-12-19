package com.mehmetalivargun.core.data

class BaseResponse<T>(
    val status: String,
    val data: T
)