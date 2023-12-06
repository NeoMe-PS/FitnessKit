package com.ps_pn.fitnesskit.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Trainers(


    @SerializedName("id")
     @Expose
    var id: String? = null,

    @SerializedName("full_name")
     @Expose
    var fullName: String? = null,

    @SerializedName("name")
     @Expose
    var name: String? = null,

    @SerializedName("last_name")
     @Expose
    var lastName: String? = null,

    @SerializedName("position")
     @Expose
    var position: String? = null,

    @SerializedName("image_url")
     @Expose
    var imageUrl: String? = null,

    @SerializedName("image_url_small")
     @Expose
    var imageUrlSmall: String? = null,

    @SerializedName("image_url_medium")
     @Expose
    var imageUrlMedium: String? = null,

    @SerializedName("description")
     @Expose
    var description: String? = null

)