package com.mehmetalivargun.core.data

interface Mapper<RestResponseModel,UIModel> {
    fun toMapUIModel(model : RestResponseModel):UIModel
}