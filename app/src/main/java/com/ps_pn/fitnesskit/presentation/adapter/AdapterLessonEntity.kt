package com.ps_pn.fitnesskit.presentation.adapter

import com.ps_pn.fitnesskit.domain.model.LessonModel

class AdapterLessonEntity (
    val type: TrainingType,
    val lesson: LessonModel?,
    val header: String?
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AdapterLessonEntity

        if (type != other.type) return false
        if (lesson != other.lesson) return false
        if (header != other.header) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + (lesson?.hashCode() ?: 0)
        result = 31 * result + (header?.hashCode() ?: 0)
        return result
    }
}



