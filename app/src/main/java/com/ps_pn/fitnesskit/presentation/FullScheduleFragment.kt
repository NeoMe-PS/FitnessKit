package com.ps_pn.fitnesskit.presentation

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ps_pn.fitnesskit.databinding.FragmentFullScheduleBinding
import com.ps_pn.fitnesskit.presentation.adapter.ScheduleAdapter
import javax.inject.Inject


class FullScheduleFragment : Fragment() {

    private var _binding: FragmentFullScheduleBinding? = null
    private val binding: FragmentFullScheduleBinding
        get() = _binding ?: throw RuntimeException("FragmentFullScheduleBinding is null")


    private val viewModel: ScheduleViewModel by lazy {
        ViewModelProvider(this)[ScheduleViewModel::class.java]
    }

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

        val scheduleAdapter = ScheduleAdapter()

        viewModel.scheduleList.observe(viewLifecycleOwner) {
            scheduleAdapter.submitList(it)
        }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            if (it) {
                binding.scheduleLoadProgress.visibility = View.VISIBLE
            } else binding.scheduleLoadProgress.visibility = View.GONE

        }
        binding.scheduleRV.adapter = scheduleAdapter

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