package com.ps_pn.fitnesskit.presentation.adapter

import androidx.recyclerview.widget.DiffUtil

class ScheduleDiffCallBack: DiffUtil.ItemCallback<AdapterLessonEntity>() {
    override fun areItemsTheSame(oldItem: AdapterLessonEntity, newItem: AdapterLessonEntity): Boolean {
        return oldItem===newItem
    }
    override fun areContentsTheSame(
        oldItem: AdapterLessonEntity,
        newItem: AdapterLessonEntity
    ): Boolean {
       return oldItem==newItem
    }
}