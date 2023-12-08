package com.ps_pn.fitnesskit.di

import android.app.Application
import com.ps_pn.fitnesskit.presentation.FullScheduleFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Inject


@Component(modules = [DataModule::class])
interface ScheduleComponent {


    fun inject(scheduleFragment: FullScheduleFragment)

    fun inject(application: App)



    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application):ScheduleComponent
    }

}