package com.ps_pn.fitnesskit.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ps_pn.fitnesskit.R

class ScheduleItemHolder(view: View) : RecyclerView.ViewHolder(view) {
    val startTime = view.findViewById<TextView>(R.id.startLessonTime_tv)
    val endTime = view.findViewById<TextView>(R.id.endLessonTime_tv)
    val lessonName = view.findViewById<TextView>(R.id.lessonName_tv)
    val lessonTrainer = view.findViewById<TextView>(R.id.lessonTrainer_tv)
    val location = view.findViewById<TextView>(R.id.lessonPlace_tv)

    val date = view.findViewById<TextView>(R.id.date)
}

