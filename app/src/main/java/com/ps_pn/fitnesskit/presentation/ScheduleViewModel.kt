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
import javax.inject.Inject

class ScheduleViewModel : ViewModel() {


    private val loadScheduleUseCase: LoadScheduleUseCase =
        LoadScheduleUseCase(ScheduleRepositoryImpl)

    private var _scheduleList = MutableLiveData<List<AdapterLessonEntity>>()
    val scheduleList: LiveData<List<AdapterLessonEntity>>
        get() = _scheduleList

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        loadData()
    }

    private fun loadData() {
        _isLoading.value = true
        viewModelScope.launch {

            val sortedLessons = loadScheduleUseCase().sorted()

            val dataWithDateKey = parseDataToMap(sortedLessons)

            val listWithViewType = parseMapToList(dataWithDateKey)
            _scheduleList.value = listWithViewType
            _isLoading.value = false
        }

    }

    private fun parseDataToMap(date: List<LessonModel>): Map<String, ArrayList<LessonModel>> {
        val dataWithDateKey = emptyMap<String, ArrayList<LessonModel>>()
            .toMutableMap()
        date.forEach {
            val formattedDate = formatDate(it.date)
            if (dataWithDateKey[formattedDate] == null) {
                dataWithDateKey[formattedDate] = ArrayList()
            }
            dataWithDateKey[formattedDate]?.add(it)
        }
        return dataWithDateKey
    }

    private fun parseMapToList(dataWithDateKey: Map<String, List<LessonModel>>): List<AdapterLessonEntity> {
        val listWithViewType = mutableListOf<AdapterLessonEntity>()
        dataWithDateKey.forEach { entry ->
            listWithViewType.add(AdapterLessonEntity(TrainingType.HEADER, null, entry.key))
            entry.value.mapTo(listWithViewType) {
                AdapterLessonEntity(type = TrainingType.TRAIN, it, null)
            }
        }
        return listWithViewType
    }

    private fun formatDate(date: String): String {
        var result = date
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val formattedDate: LocalDate = LocalDate.parse(date)
            val dayOfMonth =
                formattedDate.dayOfWeek
                    .getDisplayName(TextStyle.FULL, Locale("ru", "RU"))
                    .lowercase()
            val day = formattedDate.dayOfMonth
            val month =
                formattedDate.month
                    .getDisplayName(TextStyle.FULL, Locale("ru", "RU"))
                    .lowercase()

            result = "$dayOfMonth, $day $month"
        }
        return result
    }
}


