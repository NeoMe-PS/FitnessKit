package com.ps_pn.fitnesskit.domain.model

data class LessonModel (
    val name: String,
    val place: String,
    val coachName:String,
    val coach_id: String,
    val startTime: String,
    val endTime: String,
    val date: String,
    val tab: String,
    val color: String
): Comparable<LessonModel> {
    override fun compareTo(other: LessonModel): Int {
        val thisDate = date
        val otherDate = other.date
        return thisDate.compareTo(otherDate)
    }
}
