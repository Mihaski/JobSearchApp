package com.example.jobsearchapp.presentation.testlist

import androidx.recyclerview.widget.DiffUtil
import com.example.data.Vacancie
import com.example.data.model.NetworkVacancie

class VacancieDiffCallback : DiffUtil.ItemCallback<NetworkVacancie>() {

    override fun areItemsTheSame(oldItem: NetworkVacancie, newItem: NetworkVacancie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NetworkVacancie, newItem: NetworkVacancie): Boolean {
        return oldItem == newItem
    }
}