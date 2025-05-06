package com.example.jobsearchapp.presentation.testlist

import androidx.recyclerview.widget.DiffUtil
import com.example.data.model.IntVacancie1

class VacancieDiffCallback : DiffUtil.ItemCallback<IntVacancie1>() {

    override fun areItemsTheSame(oldItem: IntVacancie1, newItem: IntVacancie1): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: IntVacancie1, newItem: IntVacancie1): Boolean {
        return oldItem == newItem
    }
}