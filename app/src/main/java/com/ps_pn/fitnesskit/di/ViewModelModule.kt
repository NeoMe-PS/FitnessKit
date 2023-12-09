package com.ps_pn.fitnesskit.di

import androidx.lifecycle.ViewModel
import com.ps_pn.fitnesskit.presentation.fragments.schedule.ScheduleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(ScheduleViewModel::class)
    fun bindScheduleViewModel(viewModel: ScheduleViewModel): ViewModel


}