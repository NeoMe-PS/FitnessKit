package com.ps_pn.fitnesskit.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Trainers(


    @SerializedName("id")
     @Expose
    var id: String,

    @SerializedName("full_name")
     @Expose
    var fullName: String,

    @SerializedName("name")
     @Expose
    var name: String,

    @SerializedName("last_name")
     @Expose
    var lastName: String,

    @SerializedName("position")
     @Expose
    var position: String,

    @SerializedName("image_url")
     @Expose
    var imageUrl: String,

    @SerializedName("image_url_small")
     @Expose
    var imageUrlSmall: String,

    @SerializedName("image_url_medium")
     @Expose
    var imageUrlMedium: String,

    @SerializedName("description")
     @Expose
    var description: String

)