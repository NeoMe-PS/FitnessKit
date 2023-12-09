package com.ps_pn.fitnesskit.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Option(


    @SerializedName("club_name")
     @Expose
    var clubName: String,

    @SerializedName("link_android")
     @Expose
    var linkAndroid: String,

    @SerializedName("link_ios")
     @Expose
    var linkIos: String,

    @SerializedName("primary_color")
     @Expose
    var primaryColor: String,

    @SerializedName("secondary_color")
     @Expose
    var secondaryColor: String

)