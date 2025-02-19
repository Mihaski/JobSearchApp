package com.example.jobsearchapp.state

import com.example.data.model.NetworkVacancie

data class ApplicationState(
    val vacancies: List<NetworkVacancie> = emptyList(),
    val favoriteVacancieIds: Set<Int> = setOf()
)
