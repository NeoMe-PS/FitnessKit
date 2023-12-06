package com.ps_pn.fitnesskit.data.repository

import com.ps_pn.fitnesskit.data.mapper.Mapper
import com.ps_pn.fitnesskit.data.network.api.ApiFactory
import com.ps_pn.fitnesskit.domain.model.LessonModel
import com.ps_pn.fitnesskit.domain.repository.ScheduleRepository

object ScheduleRepositoryImpl : ScheduleRepository {


    private val apiService = ApiFactory.apiService
    private val mapper = Mapper()


    override suspend fun loadSchedule(): List<LessonModel> {
        val trainers = apiService.getScheduleList().trainers
        return apiService.getScheduleList().lessons.map { mapper.mapDTOToDomainModel(it,trainers,it.coachId?:"") }
    }

}