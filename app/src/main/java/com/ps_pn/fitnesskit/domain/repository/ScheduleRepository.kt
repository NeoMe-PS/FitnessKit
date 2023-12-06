package com.ps_pn.fitnesskit.domain.repository

import com.ps_pn.fitnesskit.domain.model.LessonModel

interface ScheduleRepository {

    suspend fun loadSchedule():List<LessonModel>
}