package com.ps_pn.fitnesskit.di

import android.app.Application
import javax.inject.Inject

class App : Application() {


    private val component: ScheduleComponent by lazy {
        DaggerScheduleComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

}