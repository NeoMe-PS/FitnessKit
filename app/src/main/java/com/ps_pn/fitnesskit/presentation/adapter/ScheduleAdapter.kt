package com.ps_pn.fitnesskit.presentation.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ps_pn.fitnesskit.R

class ScheduleAdapter :
    ListAdapter<AdapterLessonEntity, ScheduleItemHolder>(ScheduleDiffCallBack())
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewType = when (viewType) {
            TrainingType.HEADER.ordinal -> R.layout.schedule_item_header
            else -> R.layout.schedule_item
        }
        return ScheduleItemHolder(inflater.inflate(viewType, parent, false))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type.ordinal
    }

    override fun onBindViewHolder(holder: ScheduleItemHolder, position: Int) {
        val item = getItem(position)
        when (item.type) {
            TrainingType.TRAIN -> {
                holder.startTime.text = item.lesson?.startTime
                holder.endTime.text = item.lesson?.endTime
                holder.lessonName.text = item.lesson?.name
                holder.lessonTrainer.text = item.lesson?.coachName
                holder.location.text = item.lesson?.place
                holder.itemView.backgroundTintList = ColorStateList.valueOf(Color.parseColor(item.lesson?.color))
            }
            TrainingType.HEADER -> {
                holder.date.text = item.header
            }
        }

    }
}
