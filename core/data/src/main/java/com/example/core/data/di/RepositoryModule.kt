package com.example.core.data.di

import com.example.core.data.Repository
import com.example.core.data.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    fun bindsDataRepository(impl: RepositoryImpl): Repository
}