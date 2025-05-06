package com.example.jobsearchapp.presentation.testlist

import androidx.recyclerview.widget.DiffUtil
import com.example.data.model.NetworkVacancies

class VacancieDiffCallback : DiffUtil.ItemCallback<NetworkVacancies>() {

    override fun areItemsTheSame(oldItem: NetworkVacancies, newItem: NetworkVacancies): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NetworkVacancies, newItem: NetworkVacancies): Boolean {
        return oldItem == newItem
    }
}