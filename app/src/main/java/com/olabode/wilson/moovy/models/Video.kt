package com.olabode.wilson.moovy.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


/**
 *   Created by OLABODE WILSON on 7/3/20.
 */

@Parcelize
data class Video(
    val id: String,
    val name: String,
    val site: String,
    val key: String,
    val size: Int,
    val type: String
) : Parcelable
