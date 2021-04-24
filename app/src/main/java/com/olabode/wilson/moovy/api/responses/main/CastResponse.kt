package com.olabode.wilson.moovy.api.responses.main

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.olabode.wilson.moovy.models.Cast

data class CastResponse(
    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("cast")
    val cast: List<Cast>
)