package com.example.jobsearchapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.data.Vacancies

class VacanciesListAdapter() : ListAdapter<Vacancies, VacanciesViewHolder>(VacanciesDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacanciesViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vacancies_item, parent, false)
        return VacanciesViewHolder(view)
    }

    override fun onBindViewHolder(holder: VacanciesViewHolder, position: Int) {
        val vacancies = getItem(position)
        holder.jobTitle.text = vacancies.title
        holder.countCurrentlyViewing.text = "Cdsfasdf ${vacancies.lookingNumber} xtkjdtr"
        holder.city.text = vacancies.town
        holder.salary.text = vacancies.salaryShort
        holder.experience.text = vacancies.previewExperienceText
        holder.companyName.text=vacancies.company
        holder.dateOfPublication.text=vacancies.publishedDate
    }
    
}