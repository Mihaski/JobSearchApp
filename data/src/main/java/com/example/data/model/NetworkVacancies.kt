package com.example.data.model

data class NetworkVacancies(
    val id: String = "",
    val lookingNumber: Int = 0,
    val title: String = "",
    val address: Address? = null,
    val company: String = "",
    val experience: Experience? = null,
    val publishedDate: String = "",
    val isFavorite: Boolean = false,
    val salary: Salary? = null,
    val schedules: List<String> = listOf(""),
    val appliedNumber: Int = 0,
    val description: String = "",
    val responsibilities: String = "",
    val questions: List<String> = listOf("")
)