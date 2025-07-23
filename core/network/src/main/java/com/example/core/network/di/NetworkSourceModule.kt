package com.example.core.network.di

import com.example.core.network.DataSource
import com.example.core.network.NetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface NetworkSourceModule {

    @Binds
    fun binds(impl: NetworkDataSource): DataSource
}