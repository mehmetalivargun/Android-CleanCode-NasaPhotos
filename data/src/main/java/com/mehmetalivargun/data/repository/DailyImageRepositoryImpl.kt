package com.mehmetalivargun.data.repository

import com.mehmetalivargun.core.data.ApiResult
import com.mehmetalivargun.core.data.BaseRepository
import com.mehmetalivargun.data.api.RestApi
import com.mehmetalivargun.data.mapper.DailyImageMapper
import com.mehmetalivargun.domain.model.DailyImage
import com.mehmetalivargun.domain.repository.DailyImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mehmetalivargun.core.extension.map
import javax.inject.Inject
import javax.inject.Singleton


class DailyImageRepositoryImpl @Inject constructor(
    private val api: RestApi,
    private val mapper: DailyImageMapper
) : DailyImageRepository, BaseRepository() {
    override fun getImages(date: String) = callApi { api.getImages(date) }
        .map { apiResult ->
            apiResult.map { response ->
                response.body()!!.map {
                    mapper.toMapUIModel(it)
                }
            }
        }

    override fun getDailyImage() = callApi { api.getImage() }
        .map{ apiResult ->
            apiResult.map {
                mapper.toMapUIModel(it.body())
            }

        }
}