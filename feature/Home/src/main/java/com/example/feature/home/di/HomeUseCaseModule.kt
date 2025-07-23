package com.example.feature.home.di

import com.example.core.data.Repository
import com.example.feature.home.domain.HomeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeUseCaseModule {

    @Provides
    @Singleton
    fun providesArtUseCase(repository: Repository): HomeUseCase = HomeUseCase(repository)
}