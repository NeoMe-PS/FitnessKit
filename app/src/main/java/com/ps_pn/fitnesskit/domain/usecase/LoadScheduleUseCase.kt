package com.ps_pn.fitnesskit.domain.usecase

import com.ps_pn.fitnesskit.domain.model.LessonModel
import com.ps_pn.fitnesskit.domain.repository.ScheduleRepository

class LoadScheduleUseCase(private val repository: ScheduleRepository) {
    operator fun invoke(): List<LessonModel> {
        return repository.loadSchedule()
    }
}