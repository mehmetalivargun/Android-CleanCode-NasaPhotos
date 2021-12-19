package com.mehmetalivargun.domain.repository

import com.mehmetalivargun.core.data.ApiResult
import com.mehmetalivargun.domain.model.DailyImage
import kotlinx.coroutines.flow.Flow

interface DailyImageRepository {

    fun getImages(date:String = ""): Flow<ApiResult<List<DailyImage>>>

    fun getDailyImage(): Flow<ApiResult<DailyImage>>

}