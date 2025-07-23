package com.example.feature.home.redux

import com.example.feature.home.domain.HomeUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

typealias Middleware<S> = (store: Store<S>, homeActions: HomeActions, next: (HomeActions) -> Unit) -> Unit

fun createMiddleWare(
    homeUseCase: HomeUseCase,
    scope: CoroutineScope
): Middleware<HomeState> = { store, actions, next ->
    when (actions) {
        is HomeActions.FetchData -> {
            next(actions)
            requestData(store, homeUseCase, scope)
        }

        else -> next(actions)
    }
}

fun <S> requestData(
    store: Store<S>,
    homeUseCase: HomeUseCase,
    scope: CoroutineScope
) {
    scope.launch {
        val response = homeUseCase()
        if (response.isSuccessful) {
            response.body()?.let {
                store.dispatch(
                    HomeActions.LoadedData(
                        data = it.string()
                    )
                )
            }
        } else {
            store.dispatch(
                HomeActions.LoadedData(
                    data = "Data not found"
                )
            )
        }
    }
}