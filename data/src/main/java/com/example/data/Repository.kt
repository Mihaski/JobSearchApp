package com.example.data

import com.example.data.model.NetworkData
import com.example.data.withouthttp.listOfNetworkVacancie
import com.example.data.withouthttp.listOfVacancies

class Repository {

    fun getNetworkVacancies() = listOfNetworkVacancie

    fun getFavoriteVacancies() = listOfNetworkVacancie.filter {
        it.isFavorite
    }.map { it.id }.toSet()

    fun getVacancies() = listOfVacancies

    suspend fun getNetworkDataRepository(): NetworkData {
        return Common.retrofitService.getNetworkDataInterface().body() ?: NetworkData()
    }
}