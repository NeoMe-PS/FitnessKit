package com.ps_pn.fitnesskit.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Tabs(


    @SerializedName("id")
     @Expose
    var id: Int,

    @SerializedName("name")
     @Expose
    var name: String

)