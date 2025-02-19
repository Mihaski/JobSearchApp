package com.example.jobsearchapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Repository
import com.example.jobsearchapp.state.ApplicationState
import com.example.jobsearchapp.state.Store
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    val store = Store(ApplicationState())
    private val repository = Repository()

    fun refreshVacancie() = viewModelScope.launch {
        store.update {
            it.copy(
                vacancies = repository.getNetworkVacancies()
            )
        }
    }
}