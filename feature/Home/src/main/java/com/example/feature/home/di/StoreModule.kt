package com.example.feature.home.di

import com.example.feature.home.domain.HomeUseCase
import com.example.feature.home.redux.HomeState
import com.example.feature.home.redux.Store
import com.example.feature.home.redux.appReducer
import com.example.feature.home.redux.createMiddleWare
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object StoreModule {

    @Provides
    @Singleton
    fun providesStore(homeUseCase: HomeUseCase): Store<HomeState> = Store(
        initialState = HomeState(),
        reducer = appReducer,
        middlewares = listOf(
            createMiddleWare(
                homeUseCase,
                CoroutineScope(Dispatchers.IO)
            )
        )
    )
}