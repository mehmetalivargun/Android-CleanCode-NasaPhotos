package com.mehmetalivargun.domain.usecase

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.mehmetalivargun.core.data.ApiResult
import com.mehmetalivargun.core.domain.BaseUseCase
import com.mehmetalivargun.domain.model.DailyImage
import com.mehmetalivargun.domain.repository.DailyImageRepository
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class DailyImageUseCase @Inject constructor(
    private val repository: DailyImageRepository
): BaseUseCase<Unit, List<DailyImage>>() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun execute(parameters: Unit): Flow<ApiResult<List<DailyImage>>> {
        val now = LocalDateTime.now().minusMonths(1L)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatted = now.format(formatter)

        return repository.getImages(date = formatted)
    }
}