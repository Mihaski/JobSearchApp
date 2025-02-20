package com.example.jobsearchapp.state

import com.example.data.model.IntVacancie

data class ApplicationState(
    val vacancies: List<IntVacancie> = emptyList(),
    val favoriteVacancieIds: Set<Int> = emptySet()
)