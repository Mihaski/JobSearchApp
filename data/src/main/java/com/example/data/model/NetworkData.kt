package com.example.data.model

import com.google.gson.annotations.SerializedName

data class NetworkData(
    @SerializedName("offers")
    val networkOffers: List<NetworkOffers>? = null,
    @SerializedName("vacancies")
    val networkVacancies: List<NetworkVacancies>? = null
)