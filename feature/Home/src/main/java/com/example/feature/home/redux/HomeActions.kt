package com.example.feature.home.redux

sealed class HomeActions {
    data object FetchData : HomeActions()
    data class LoadedData(val data: String) : HomeActions()
}