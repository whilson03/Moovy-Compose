package com.olabode.wilson.moovy.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

/**
 *   Created by OLABODE WILSON on 8/1/20.
 */

@Parcelize
data class Genres(
    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("name")
    val name: String
) : Parcelable