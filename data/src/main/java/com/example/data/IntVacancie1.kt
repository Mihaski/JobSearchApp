package com.example.data

import com.example.data.model.Address
import com.example.data.model.Experience
import com.example.data.model.Salary

data class IntVacancie1(
    val address: Address,
    val appliedNumber: Int,
    val company: String,
    val description: String,
    val experience: Experience,
    val id: Int,
    var isFavorite: Boolean,
    val lookingNumber: Int,
    val publishedDate: String,
    val questions: List<String>,
    val responsibilities: String,
    val salary: Salary,
    val schedules: List<String>,
    val title: String
)