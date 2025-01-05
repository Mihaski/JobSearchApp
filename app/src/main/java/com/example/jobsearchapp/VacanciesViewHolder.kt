package com.example.jobsearchapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VacanciesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val countCurrentlyViewing = view.findViewById<TextView>(R.id.count_currently_viewing)
    val jobTitle = view.findViewById<TextView>(R.id.job_title)
    val salary = view.findViewById<TextView>(R.id.salary)
    val city = view.findViewById<TextView>(R.id.city)
    val companyName = view.findViewById<TextView>(R.id.company_name)
    val experience = view.findViewById<TextView>(R.id.experience)
    val dateOfPublication = view.findViewById<TextView>(R.id.date_of_publication)
}