package com.ps_pn.fitnesskit.di

import com.ps_pn.fitnesskit.data.network.api.ApiFactory
import com.ps_pn.fitnesskit.data.network.api.ApiService
import com.ps_pn.fitnesskit.data.repository.ScheduleRepositoryImpl
import com.ps_pn.fitnesskit.domain.repository.ScheduleRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {


    @Binds
    fun bindScheduleRepository(impl: ScheduleRepositoryImpl):ScheduleRepository


    companion object{

        @Provides
        fun provideApiService():ApiService{
            return ApiFactory.apiService
        }
    }

}