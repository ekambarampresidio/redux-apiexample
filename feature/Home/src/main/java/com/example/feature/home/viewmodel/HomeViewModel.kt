package com.example.feature.home.viewmodel

import androidx.lifecycle.ViewModel
import com.example.feature.home.redux.HomeActions
import com.example.feature.home.redux.HomeState
import com.example.feature.home.redux.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val store: Store<HomeState>
) : ViewModel() {

    init {
        loadData()
    }

    val data : StateFlow<HomeState>
        get() = store.state

    private fun loadData() {
        store.dispatch(HomeActions.FetchData)
    }
}