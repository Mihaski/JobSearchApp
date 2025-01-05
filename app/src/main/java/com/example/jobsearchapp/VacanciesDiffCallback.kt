package com.example.jobsearchapp

import androidx.recyclerview.widget.DiffUtil
import com.example.data.Vacancies

class VacanciesDiffCallback:DiffUtil.ItemCallback<Vacancies>() {

    override fun areItemsTheSame(oldItem: Vacancies, newItem: Vacancies): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Vacancies, newItem: Vacancies): Boolean {
        return oldItem == newItem
    }
}