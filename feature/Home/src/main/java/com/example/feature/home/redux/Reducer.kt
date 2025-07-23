package com.example.feature.home.redux

typealias Reducer<State> = (State, HomeActions) -> State

val appReducer: Reducer<HomeState> = { state, actions ->
    when (actions) {
        is HomeActions.FetchData -> fetchData(state)
        is HomeActions.LoadedData -> loadedData(state, actions.data)
    }
}

fun fetchData(state: HomeState): HomeState {
    return state.copy(isLoading = true)
}

fun loadedData(state: HomeState, data: String): HomeState {
    return state.copy(isLoading = false, data = data)
}