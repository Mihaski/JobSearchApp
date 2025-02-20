package com.example.jobsearchapp.presentation.testlist

import androidx.recyclerview.widget.DiffUtil
import com.example.data.Vacancie
import com.example.data.model.IntVacancie
import com.example.data.model.NetworkVacancie

class VacancieDiffCallback : DiffUtil.ItemCallback<IntVacancie>() {

    override fun areItemsTheSame(oldItem: IntVacancie, newItem: IntVacancie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: IntVacancie, newItem: IntVacancie): Boolean {
        return oldItem == newItem
    }
}