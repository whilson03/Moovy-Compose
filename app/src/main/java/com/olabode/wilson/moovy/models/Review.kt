package com.olabode.wilson.moovy.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


/**
 *   Created by OLABODE WILSON on 7/3/20.
 */

@Parcelize
data class Review(
    val id: String,
    val author: String,
    val content: String,
    val url: String
) : Parcelable
