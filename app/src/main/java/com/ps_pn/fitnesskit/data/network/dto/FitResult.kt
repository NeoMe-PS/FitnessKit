package com.ps_pn.fitnesskit.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class FitResult(


    @SerializedName("trainers")
     @Expose
    var trainers: List<Trainers> ,

    @SerializedName("tabs")
     @Expose
    var tabs: List<Tabs> ,

    @SerializedName("lessons")
     @Expose
    var lessons: List<Lessons> ,

    @SerializedName("option")
     @Expose
    var option: Option? = Option()


)
