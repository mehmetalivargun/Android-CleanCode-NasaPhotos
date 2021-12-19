package com.mehmetalivargun.data.di

import com.mehmetalivargun.data.repository.DailyImageRepositoryImpl
import com.mehmetalivargun.domain.repository.DailyImageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
   @Singleton
    @Binds
    abstract fun bindDailyImageRepository(repositoryImpl: DailyImageRepositoryImpl): DailyImageRepository


}