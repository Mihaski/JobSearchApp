package com.example.jobsearchapp.presentation.testlist

import androidx.recyclerview.widget.DiffUtil
import com.example.data.Vacancie

class VacancieDiffCallback : DiffUtil.ItemCallback<Vacancie>() {

    override fun areItemsTheSame(oldItem: Vacancie, newItem: Vacancie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Vacancie, newItem: Vacancie): Boolean {
        return oldItem == newItem
    }
}