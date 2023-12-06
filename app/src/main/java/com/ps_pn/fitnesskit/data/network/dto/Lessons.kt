package com.ps_pn.fitnesskit.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Lessons(
    @SerializedName("name")
     @Expose
    var name: String? ,

    @SerializedName("description")
     @Expose
    var description: String? ,

    @SerializedName("place")
     @Expose
    var place: String? ,

    @SerializedName("coach_id")
     @Expose
    var coachId: String? ,

    @SerializedName("startTime")
     @Expose
    var startTime: String? ,

    @SerializedName("endTime")
     @Expose
    var endTime: String? ,

    @SerializedName("date")
     @Expose
    var date: String? ,

    @SerializedName("tab")
     @Expose
    var tab: String? ,

    @SerializedName("color")
     @Expose
    var color: String? ,
)