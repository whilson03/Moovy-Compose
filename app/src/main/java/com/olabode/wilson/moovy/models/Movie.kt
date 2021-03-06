package com.olabode.wilson.moovy.models

import android.os.Parcelable
import com.olabode.wilson.moovy.models.Keyword
import com.olabode.wilson.moovy.models.Review
import com.olabode.wilson.moovy.models.Video


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/**
 *   Created by OLABODE WILSON on 7/3/20.
 */

@Parcelize
data class Movie(
    @Expose
    @SerializedName("id")
    val id: Long,

    @Expose
    @SerializedName("page")
    val page: Int,
    @Expose
    @SerializedName("keywords")
    val keywords: List<Keyword>? = ArrayList(),
    @Expose
    @SerializedName("videos")
    val videos: List<Video>? = ArrayList(),
    @Expose
    @SerializedName("reviews")
    val reviews: List<Review>? = ArrayList(),
    @Expose
    @SerializedName("poster_path")
    val poster_path: String?,
    @Expose
    @SerializedName("adult")
    val adult: Boolean,
    @Expose
    @SerializedName("overview")
    val overview: String,
    @Expose
    @SerializedName("release_date")
    val release_date: String,
    @Expose
    @SerializedName("genre_ids")
    val genre_ids: List<Int>,
    @Expose
    @SerializedName("original_title")
    val original_title: String,
    @Expose
    @SerializedName("original_language")
    val original_language: String,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("backdrop_path")
    val backdrop_path: String?,
    @Expose
    @SerializedName("popularity")
    val popularity: Float,
    @Expose
    @SerializedName("vote_count")
    val vote_count: Int,
    @Expose
    @SerializedName("video")
    val video: Boolean,
    @Expose
    @SerializedName("vote_average")
    val vote_average: Float
) :Parcelable
