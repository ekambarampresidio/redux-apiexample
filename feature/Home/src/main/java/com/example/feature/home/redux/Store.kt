package com.example.feature.home.redux

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class Store<State>(
    initialState: State,
    private val reducer: Reducer<State>,
    private val middlewares: List<Middleware<State>>
) {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()

    fun dispatch(homeActions: HomeActions) {
        val chain: (HomeActions) -> Unit = { act ->
            _state.value = reducer(state.value, act)
        }
        val composed = middlewares.foldRight(chain) { middleware, next ->
            { act -> middleware(this, act, next) }
        }
        composed(homeActions)
    }
}