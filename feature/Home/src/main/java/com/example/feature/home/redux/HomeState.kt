package com.example.feature.home.redux

data class HomeState(
    val data: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false
)