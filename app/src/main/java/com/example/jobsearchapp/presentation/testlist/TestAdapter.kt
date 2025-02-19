package com.example.jobsearchapp.presentation.testlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.data.Vacancie
import com.example.data.model.NetworkVacancie
import com.example.jobsearchapp.R

class TestAdapter : ListAdapter<NetworkVacancie, TestViewHolder>(VacancieDiffCallback()) {

    var onVacancieClickListener: ((NetworkVacancie) -> Unit)? = null

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
        holder.tvCity.text = "${vacancie.address.town}, ${vacancie.address.street}, ${vacancie.address.house}"
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
            val resIdIn = if (vacancie.isFavorite) R.drawable.heart_blue
            else R.drawable.ic_favorites
            onVacancieClickListener?.invoke(vacancie)
            holder.isFavoriteButton.setImageResource(
                resIdIn
            )
//            notifyItemChanged(position)
        }
    }

}