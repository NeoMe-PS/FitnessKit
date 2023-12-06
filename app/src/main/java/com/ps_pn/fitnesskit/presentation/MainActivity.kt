package com.ps_pn.fitnesskit.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ps_pn.fitnesskit.R
import com.ps_pn.fitnesskit.data.repository.ScheduleRepositoryImpl
import com.ps_pn.fitnesskit.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val coroutineScope = CoroutineScope(Dispatchers.IO)

        coroutineScope.launch {
         val data=  ScheduleRepositoryImpl.loadSchedule()
            for ( i in data){
                Log.i("TestLOG", "Test $i")
            }
        }


    }
}