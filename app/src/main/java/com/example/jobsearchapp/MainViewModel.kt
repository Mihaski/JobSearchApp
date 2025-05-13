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

    fun refreshDataFromApi() = viewModelScope.launch {
        val listNetworkData = repository.getNetworkDataRepository()
        val isFavorite =
            listNetworkData.networkVacancies?.filter { it.isFavorite }?.map { it.id }?.toSet()
        store.update {
            it.copy(
                vacancies = repository.getNetworkVacancies(),
                favoriteVacancieSet = isFavorite ?: emptySet(),
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

    private val _navViewIsEnabled = MutableLiveData<Boolean>()

    val navViewIsEnabled: LiveData<Boolean>
        get() = _navViewIsEnabled

    fun resetNavViewIsEnable() {
        _navViewIsEnabled.value = true
    }

    init {
        _navViewIsEnabled.value = false
    }
}