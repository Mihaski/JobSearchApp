package com.example.jobsearchapp.presentation.testlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.data.Vacancie
import com.example.jobsearchapp.R

class TestAdapter : ListAdapter<Vacancie, TestViewHolder>(VacancieDiffCallback()) {

    var onVacancieClickListener: ((Vacancie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vacancies_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val vacancie = getItem(position)
        holder.tvTitle.text = vacancie.title
        holder.tvLookingNumber.text = "Сейчас просматривает ${vacancie.lookingNumber} человек"
        holder.tvCity.text = vacancie.town
        holder.tvSalary.text = vacancie.salaryShort
        holder.tvExpirience.text = vacancie.previewExperienceText
        holder.tvCompanyName.text = vacancie.company
        holder.tvDateOfPublication.text = vacancie.publishedDate
        val resId = if (vacancie.isFavorite == "false") R.drawable.ic_favorites
        else R.drawable.heart_blue
        holder.isFavoriteButton.setImageResource(
            resId
        )
        holder.isFavoriteButton.setOnClickListener {
            onVacancieClickListener?.invoke(vacancie)
            holder.isFavoriteButton.setImageResource(
                resId
            )
//            notifyItemChanged(position)
        }
    }

}