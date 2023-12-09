package com.ps_pn.fitnesskit.presentation.fragments.schedule

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ps_pn.fitnesskit.databinding.FragmentFullScheduleBinding
import com.ps_pn.fitnesskit.di.App
import com.ps_pn.fitnesskit.di.ScheduleComponent
import com.ps_pn.fitnesskit.presentation.ViewModelFactory
import com.ps_pn.fitnesskit.presentation.adapter.ScheduleAdapter
import javax.inject.Inject


class FullScheduleFragment : Fragment() {

    private var _binding: FragmentFullScheduleBinding? = null
    private val binding: FragmentFullScheduleBinding
        get() = _binding ?: throw RuntimeException("FragmentFullScheduleBinding is null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component: ScheduleComponent by lazy {
        (requireActivity().application as App).component
    }

    private lateinit var viewModel: ScheduleViewModel

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this, viewModelFactory)[ScheduleViewModel::class.java]
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