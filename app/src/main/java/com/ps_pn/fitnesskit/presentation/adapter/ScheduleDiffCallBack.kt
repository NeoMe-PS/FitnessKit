package com.ps_pn.fitnesskit.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ps_pn.fitnesskit.domain.model.LessonModel

class ScheduleDiffCallBack: DiffUtil.ItemCallback<LessonModel>() {
    override fun areItemsTheSame(oldItem: LessonModel, newItem: LessonModel): Boolean {
        return oldItem===newItem
    }

    override fun areContentsTheSame(oldItem: LessonModel, newItem: LessonModel): Boolean {
        return oldItem==newItem
    }
}