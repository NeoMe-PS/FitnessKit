package com.ps_pn.fitnesskit.domain.model

data class LessonModel(
    val name: String,
    val place: String,
    val coachName:String,
    val coach_id: String,
    val startTime: String,
    val endTime: String,
    val date: String,
    val service_id: String,
    val tab: String,
    val color: String
)
