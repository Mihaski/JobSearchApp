package com.example.jobsearchapp.state

import com.example.data.model.IntVacancie1
import com.example.data.model.NetworkData

data class ApplicationState(
    val vacancies: List<IntVacancie1> = emptyList(),
    val favoriteVacancieIds: Set<Int> = emptySet(),
    val networkData: NetworkData = NetworkData(arrayListOf(), arrayListOf())
)