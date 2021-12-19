package com.mehmetalivargun.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class DailyImageModel(
    @field:Json(name = "copyright")
    val copyright: String?=null,
    @field:Json(name = "date")
    val date: String?=null,
    @field:Json(name = "explanation")
    val explanation: String?=null,
    @field:Json(name = "hdurl")
    val hdurl: String?=null,
    @field:Json(name = "media_type")
    val mediaType: String?=null,
    @field:Json(name = "service_version")
    val serviceVersion: String?=null,
    @field:Json(name = "title")
    val title: String?=null,
    @field:Json(name = "url")
    val url: String?=null
)