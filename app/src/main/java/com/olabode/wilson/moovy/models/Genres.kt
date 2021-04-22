package com.olabode.wilson.moovy.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *   Created by OLABODE WILSON on 8/1/20.
 */
data class Genres(
    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("name")
    val name: String
)