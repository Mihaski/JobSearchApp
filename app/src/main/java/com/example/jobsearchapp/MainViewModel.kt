package com.example.jobsearchapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Repository
import com.example.jobsearchapp.state.ApplicationState
import com.example.jobsearchapp.state.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val store: Store<ApplicationState>,
) : ViewModel() {

    private val repository = Repository()

    fun refreshVacancie() = viewModelScope.launch {
        val listNetworkData = repository.getNetworkDataRepository()
        store.update {
            it.copy(
                vacancies = repository.getNetworkVacancies(),
                favoriteVacancieIds = repository.getFavoriteVacancies(),
                networkData = listNetworkData
            )
        }
    }

    private val _errorInputEmail = MutableLiveData<Boolean>()
    val errorInputEmail: LiveData<Boolean>
        get() = _errorInputEmail

    fun resetErrorInputEmail() {
        _errorInputEmail.value = false
    }

    fun validateEmail(email: String): Boolean {
        var result = true
        if (email.isBlank()) {
            _errorInputEmail.value = true
            result = false
        }
        if (!email.contains("@")) {
            _errorInputEmail.value = true
            result = false
        }
        return result
    }
}