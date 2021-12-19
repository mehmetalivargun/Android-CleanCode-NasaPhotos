package com.mehmetalivargun.data.mapper

import android.util.Log
import com.mehmetalivargun.core.data.Mapper
import com.mehmetalivargun.data.model.DailyImageModel
import com.mehmetalivargun.domain.model.DailyImage
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DailyImageMapper @Inject constructor(): Mapper<DailyImageModel?, DailyImage>{
    override fun toMapUIModel(model: DailyImageModel?): DailyImage {

        return DailyImage(
            copyright = model?.copyright.orEmpty(),
            date = model?.date.orEmpty(),
            explanation = model?.explanation.orEmpty(),
            hdurl = model?.hdurl.orEmpty(),
            mediaType = model?.mediaType.orEmpty(),
            serviceVersion = model?.serviceVersion.orEmpty(),
            title = model?.title.orEmpty(),
            url = model?.url.orEmpty()
        )
    }
}