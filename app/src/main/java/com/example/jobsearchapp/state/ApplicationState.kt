package com.example.jobsearchapp.state

import com.example.data.Vacancie

data class ApplicationState(
    val vacancies: List<Vacancie> = emptyList(),
    val favoriteVacancieIds: Set<Int> = emptySet()
)
