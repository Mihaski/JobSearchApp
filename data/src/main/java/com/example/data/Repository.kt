package com.example.data

import com.example.data.withouthttp.listOfVacancies
import retrofit2.Response

class Repository {

    fun getVacancies() = listOfVacancies

    suspend fun getNetworkVacancies(): Response<List<Vacancie>> {
        return Common.retrofitService.getVacanciesList()
    }
    suspend fun getOffers(): Response<List<Offers>> {
        return Common.retrofitService.getOffersList()
    }
}