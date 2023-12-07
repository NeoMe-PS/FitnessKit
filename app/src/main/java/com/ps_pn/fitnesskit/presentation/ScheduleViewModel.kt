package com.ps_pn.fitnesskit.presentation

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ps_pn.fitnesskit.data.repository.ScheduleRepositoryImpl
import com.ps_pn.fitnesskit.domain.model.LessonModel
import com.ps_pn.fitnesskit.domain.usecase.LoadScheduleUseCase
import com.ps_pn.fitnesskit.presentation.adapter.AdapterLessonEntity
import com.ps_pn.fitnesskit.presentation.adapter.TrainingType
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

class ScheduleViewModel : ViewModel() {

    private var _scheduleList = MutableLiveData<List<AdapterLessonEntity>>()

    val scheduleList: LiveData<List<AdapterLessonEntity>>
        get() = _scheduleList


    private val loadScheduleUseCase = LoadScheduleUseCase(ScheduleRepositoryImpl)

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val data = loadScheduleUseCase().sorted()

            val map = emptyMap<String, ArrayList<LessonModel>>().toMutableMap()

            data.forEach {
                val formattedDate = formatDate(it.date)
                if (map[formattedDate] == null) {
                    map[formattedDate] = ArrayList()
                }
                map[formattedDate]?.add(it)
            }
            val listWithViewType = mutableListOf<AdapterLessonEntity>()
            map.forEach { entry ->
                listWithViewType.add(AdapterLessonEntity(TrainingType.HEADER, null, entry.key))
                entry.value.mapTo(listWithViewType) {
                    AdapterLessonEntity(type = TrainingType.TRAIN, it, null)
                }
            }

            _scheduleList.value = listWithViewType
        }
    }

    private fun formatDate(date: String): String {
        var result = date
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val formattedDate: LocalDate = LocalDate.parse(date)

            val dayOfMonth =
                formattedDate.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ru", "RU"))
                    .lowercase()
            val day = formattedDate.dayOfMonth
            val month =
                formattedDate.month.getDisplayName(TextStyle.FULL, Locale("ru", "RU")).lowercase()

            result = "$dayOfMonth, $day $month"
        }
        return result
    }
}


