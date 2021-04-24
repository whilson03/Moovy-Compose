package com.olabode.wilson.moovy.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Cast(
    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("original_name")
    val original_name: String,

    @Expose
    @SerializedName("profile_path")
    val profile_path: String,

    @Expose
    @SerializedName("character")
    val character: String
)