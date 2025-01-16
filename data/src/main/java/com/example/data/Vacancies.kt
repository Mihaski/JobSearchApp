package com.example.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vacancies(
    val id: String = "",
    val lookingNumber: String = "",
    val title: String = "",
    val town: String = "",
    val street: String = "",
    val house: String = "",
    val company: String = "",
    val previewExperienceText: String = "",
    val experienceText: String = "",
    val publishedDate: String = "",
    val isFavorite: String = "",
    val salaryShort: String = "",
    val salaryFull: String = "",
    val schedules: String = "",
    val appliedNumber: String = "",
    val description: String = "",
    val responsibilities: String = "",
    val questions: String = "",
) : VerticalBaseClass, Parcelable
