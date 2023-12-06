package com.ps_pn.fitnesskit.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ps_pn.fitnesskit.databinding.ScheduleItemBinding
import com.ps_pn.fitnesskit.domain.model.LessonModel

class ScheduleAdapter : ListAdapter<LessonModel, ScheduleItemHolder>(ScheduleDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleItemHolder {
        val binding =
            ScheduleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleItemHolder, position: Int) {
       val item = getItem(position)
        with(holder.binding){
            startLessonTimeTv.text = item.startTime
            endLessonTimeTv.text = item.endTime
            lessonNameTv.text = item.name
            lessinTrainerTv.text = item.coachName
            lessonPlaceTv.text = item.place

        }
    }
}