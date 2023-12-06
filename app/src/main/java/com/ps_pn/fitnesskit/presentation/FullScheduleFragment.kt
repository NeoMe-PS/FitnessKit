package com.ps_pn.fitnesskit.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ps_pn.fitnesskit.R
import com.ps_pn.fitnesskit.data.network.dto.Lessons
import com.ps_pn.fitnesskit.data.repository.ScheduleRepositoryImpl
import com.ps_pn.fitnesskit.databinding.FragmentFullScheduleBinding
import com.ps_pn.fitnesskit.domain.model.LessonModel
import com.ps_pn.fitnesskit.presentation.adapter.ScheduleAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.RuntimeException


class FullScheduleFragment : Fragment() {

    private var _binding: FragmentFullScheduleBinding? = null
    private val binding: FragmentFullScheduleBinding
        get() = _binding ?: throw RuntimeException("FragmentFullScheduleBinding is null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFullScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coroutineScope = CoroutineScope(Dispatchers.Main)
        val scheduleAdapter:ScheduleAdapter = ScheduleAdapter()

         coroutineScope.launch {
             Log.i("TestLOG", "coroutine start!")
            val data  =  ScheduleRepositoryImpl.loadSchedule()
             Log.i("TestLOG", "$data")
            binding.scheduleRV.adapter = scheduleAdapter
            scheduleAdapter.submitList(data)
             Log.i("TestLOG", "coroutine end!")
        }


    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FullScheduleFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}