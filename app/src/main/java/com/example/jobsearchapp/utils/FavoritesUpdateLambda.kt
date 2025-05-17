package com.example.jobsearchapp.utils

import com.example.data.model.NetworkVacancies
import com.example.jobsearchapp.MainViewModel

fun favoritesUpdateLambdaMainViewModel(viewModel: MainViewModel, netVacId: NetworkVacancies) {
    viewModel.store.update { currentState ->
        val current = currentState.favoriteVacancieSet
        val new = if (current.contains(netVacId.id))
            current.filter { it != netVacId.id }.toSet()
        else current + setOf(netVacId.id)
        return@update currentState.copy(favoriteVacancieSet = new)
    }
}