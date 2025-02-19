package com.example.jobsearchapp.presentation.testlist

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobsearchapp.R

class TestViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvLookingNumber=view.findViewById<TextView>(R.id.count_currently_viewing)
    val tvTitle=view.findViewById<TextView>(R.id.job_title)
    val tvSalary=view.findViewById<TextView>(R.id.salary)
    val tvCity=view.findViewById<TextView>(R.id.city)
    val tvCompanyName=view.findViewById<TextView>(R.id.company_name)
    val tvExpirience=view.findViewById<TextView>(R.id.experience)
    val tvDateOfPublication=view.findViewById<TextView>(R.id.date_of_publication)
    val isFavoriteButton=view.findViewById<ImageButton>(R.id.butt_favorites_heart_blue_or_inactive)
}