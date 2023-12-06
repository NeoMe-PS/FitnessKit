package com.ps_pn.fitnesskit.data.network.api

import androidx.lifecycle.LiveData
import com.ps_pn.fitnesskit.data.network.dto.FitResult
import retrofit2.http.GET


interface ApiService {


    @GET("schedule/get_v3/?club_id=2")
    suspend fun getScheduleList():FitResult



}