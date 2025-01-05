package com.example.data

data class Vacancies(
    var id: String = "",
    var lookingNumber: String = "",
    var title: String = "",
    var town: String = "",
    var street: String = "",
    var house: String = "",
    var company: String = "",
    var previewExperienceText: String = "",
    var experienceText: String = "",
    var publishedDate: String = "",
    var isFavorite: String = "",
    var salaryShort: String = "",
    var salaryFull: String = "",
    var schedules: String = "",
    var appliedNumber: String = "",
    var description: String = "",
    var responsibilities: String = "",
    var questions: String = "",
) : ListMainScreenVerticalItem
