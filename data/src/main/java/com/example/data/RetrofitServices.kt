package com.example.data

import com.example.data.model.NetworkData
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServices {

    @GET("uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
    suspend fun getNetworkDataInterface(): Response<NetworkData>
}