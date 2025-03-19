package com.example.data

import com.example.data.withouthttp.listOfNetworkVacancie
import com.example.data.withouthttp.listOfVacancies
import retrofit2.Response

class Repository {

    fun getNetworkVacancies() = listOfNetworkVacancie

    fun getFavoriteVacancies() = listOfNetworkVacancie.filter {
        it.isFavorite
    }.map { it.id }.toSet()

    fun getVacancies() = listOfVacancies

    suspend fun getResponseVacancies(): Response<List<Vacancie>> {
        return Common.retrofitService.getVacanciesList()
    }

    suspend fun getOffers(): Response<List<Offers>> {
        return Common.retrofitService.getOffersList()
    }

//    suspend fun getGavno():Response<Gavno> {
//        return Common.retrofitService.getAbracadabraGDisk()
//    }
}