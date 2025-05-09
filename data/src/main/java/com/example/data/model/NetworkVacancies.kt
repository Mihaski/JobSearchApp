package com.example.data.model

import android.os.Parcelable
import com.example.data.VerticalBaseClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class NetworkVacancies(
    val id: String = "",
    val lookingNumber: Int = 0,
    val title: String = "",
    val address: Address? = null,
    val company: String = "",
    val experience: Experience? = null,
    val publishedDate: String = "",
    var isFavorite: Boolean = false,
    val salary: Salary? = null,
    val schedules: List<String> = listOf(""),
    val appliedNumber: Int = 0,
    val description: String = "",
    val responsibilities: String = "",
    val questions: List<String> = listOf(""),
) : VerticalBaseClass, Parcelable