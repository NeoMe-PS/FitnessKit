package com.ps_pn.fitnesskit.di

import android.app.Application
import com.ps_pn.fitnesskit.presentation.fragments.schedule.FullScheduleFragment
import dagger.BindsInstance
import dagger.Component


@Component(modules = [DataModule::class,ViewModelModule::class])
interface ScheduleComponent {


    fun inject(scheduleFragment: FullScheduleFragment)

    fun inject(application: App)



    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application):ScheduleComponent
    }

}