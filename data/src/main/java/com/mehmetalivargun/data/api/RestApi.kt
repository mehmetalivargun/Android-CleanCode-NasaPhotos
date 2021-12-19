package com.mehmetalivargun.data.api

import com.mehmetalivargun.core.data.BaseResponse
import com.mehmetalivargun.data.model.DailyImageModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {
    @GET(IMAGES)
    suspend fun getImages(@Query("start_date") date:String="" ) : Response<List<DailyImageModel>>
    @GET(IMAGES)
    suspend fun getImage( ) : Response<DailyImageModel>


    private companion object EndPoints {
        const val API_KEY="hbvGwaeaxGO7P4DHDpFZTjE41qzjCbvTlTVDYVgp"
        const val IMAGES = "planetary/apod/?api_key=$API_KEY"
    }
}