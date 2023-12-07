package com.ps_pn.fitnesskit.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ps_pn.fitnesskit.data.repository.ScheduleRepositoryImpl
import com.ps_pn.fitnesskit.domain.model.LessonModel
import com.ps_pn.fitnesskit.domain.usecase.LoadScheduleUseCase
import kotlinx.coroutines.launch

class ScheduleViewModel : ViewModel() {

    private var _scheduleList = MutableLiveData<List<LessonModel>>()

    val scheduleList: LiveData<List<LessonModel>>
        get() = _scheduleList


    private val loadScheduleUseCase = LoadScheduleUseCase(ScheduleRepositoryImpl)

    init {
       loadData()
    }

    private fun loadData(){
        viewModelScope.launch {
            val data = loadScheduleUseCase()
            _scheduleList.value = data
        }
    }


}