package com.mehmetalivargun.domain.usecase

import com.mehmetalivargun.core.data.ApiResult
import com.mehmetalivargun.core.domain.BaseUseCase
import com.mehmetalivargun.domain.model.DailyImage
import com.mehmetalivargun.domain.repository.DailyImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodaysImageUseCase @Inject constructor(
    private val repository: DailyImageRepository
): BaseUseCase<Unit, DailyImage>() {


    override fun execute(parameters: Unit): Flow<ApiResult<DailyImage>> {
        return repository.getDailyImage()
    }
}