package com.ps_pn.fitnesskit.data.repository

import com.ps_pn.fitnesskit.data.mapper.Mapper
import com.ps_pn.fitnesskit.data.network.api.ApiFactory.apiService
import com.ps_pn.fitnesskit.domain.model.LessonModel
import com.ps_pn.fitnesskit.domain.repository.ScheduleRepository
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(private val mapper: Mapper )
    : ScheduleRepository {


    override suspend fun loadSchedule(): List<LessonModel> {
        val trainers = apiService.getScheduleList().trainers
        return apiService.getScheduleList().lessons.map { mapper.mapDTOToDomainModel(it,trainers,it.coachId?:"") }
    }

}