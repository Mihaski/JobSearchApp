package com.example.jobsearchapp.presentation.testlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.data.model.IntVacancie1
import com.example.jobsearchapp.R

class TestAdapter : ListAdapter<IntVacancie1, TestViewHolder>(VacancieDiffCallback()) {

    var onFavoriteClickListener: ((IntVacancie1) -> Unit)? = null

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
        holder.tvCity.text =
            "${vacancie.address.town}, ${vacancie.address.street}, ${vacancie.address.house}"
        holder.tvSalary.text = vacancie.salary.short
        holder.tvExpirience.text = vacancie.experience.previewText
        holder.tvCompanyName.text = vacancie.company
        holder.tvDateOfPublication.text = vacancie.publishedDate
        val resId = if (vacancie.isFavorite) R.drawable.heart_blue
        else R.drawable.ic_favorites
        holder.isFavoriteButton.setImageResource(
            resId
        )
        holder.isFavoriteButton.setOnClickListener {
            onFavoriteClickListener?.invoke(vacancie)
            vacancie.isFavorite = !vacancie.isFavorite

            val resIdIn = if (vacancie.isFavorite) R.drawable.heart_blue
            else R.drawable.ic_favorites
            holder.isFavoriteButton.setImageResource(
                resIdIn
            )
        }
    }


}