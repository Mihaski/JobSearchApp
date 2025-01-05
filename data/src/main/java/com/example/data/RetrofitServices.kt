package com.example.data

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServices {
    @GET("offers")
    suspend fun getOffersList(): Response<List<Offers>>

    @GET("vacancies")
    suspend fun getVacanciesList(): Response<List<Vacancies>>
}