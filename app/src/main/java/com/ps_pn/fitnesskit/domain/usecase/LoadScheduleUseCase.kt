package com.ps_pn.fitnesskit.domain.usecase

import com.ps_pn.fitnesskit.domain.model.LessonModel
import com.ps_pn.fitnesskit.domain.repository.ScheduleRepository
import javax.inject.Inject

class LoadScheduleUseCase @Inject constructor (private val repository: ScheduleRepository) {
    suspend operator fun invoke(): List<LessonModel> {
        return repository.loadSchedule()
    }
}