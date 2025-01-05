package com.example.data

import retrofit2.Response

class Repository {
    suspend fun getVacancies(): Response<List<Vacancies>> {
        return Common.retrofitService.getVacanciesList()
    }
    suspend fun getOffers(): Response<List<Offers>> {
        return Common.retrofitService.getOffersList()
    }
}