package com.ps_pn.fitnesskit.data.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  ApiFactory {

    private const val BASE_URL = "https://olimpia.fitnesskit-admin.ru/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

     val apiService: ApiService = retrofit.create(ApiService::class.java)
}