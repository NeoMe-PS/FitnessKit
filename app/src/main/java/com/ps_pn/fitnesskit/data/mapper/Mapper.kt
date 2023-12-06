package com.ps_pn.fitnesskit.data.mapper

import com.ps_pn.fitnesskit.data.network.dto.Lessons
import com.ps_pn.fitnesskit.data.network.dto.Trainers
import com.ps_pn.fitnesskit.domain.model.LessonModel

class Mapper {

    fun mapDTOToDomainModel(lessonDTO: Lessons,list: List<Trainers>,currentTrainerID:String): LessonModel {
        return LessonModel(
            name = lessonDTO.name,
            place = lessonDTO.place,
            coachName = getTrainerName(list,currentTrainerID),
            coach_id = lessonDTO.coachId,
            startTime = lessonDTO.startTime,
            endTime = lessonDTO.endTime,
            date = lessonDTO.date,
            tab = lessonDTO.tab,
            color = lessonDTO.color
        )
    }

   private fun getTrainerName(trainers: List<Trainers>,currentTrainerID:String):String{
       for (i in trainers) {
           if (i.id == currentTrainerID) {
               return i.fullName?:""
           }
       }
       return ""
    }

}

