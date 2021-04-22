package com.olabode.wilson.moovy.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TvSeries(
    @Expose
    @SerializedName("page")
    var page: Int,
    @Expose
    @SerializedName("keywords")
    var keywords: List<Keyword>? = ArrayList(),
    @Expose
    @SerializedName("videos")
    var videos: List<Video>? = ArrayList(),
    @Expose
    @SerializedName("reviews")
    var reviews: List<Review>? = ArrayList(),
    @Expose
    @SerializedName("poster_path")
    val poster_path: String?,
    @Expose
    @SerializedName("popularity")
    val popularity: Float?,
    @Expose
    @SerializedName("id")
    val id: Int?,
    @Expose
    @SerializedName("backdrop_path")
    val backdrop_path: String?,
    @Expose
    @SerializedName("vote_average")
    val vote_average: Float?,
    @Expose
    @SerializedName("overview")
    val overview: String?,
    @Expose
    @SerializedName("first_air_date")
    val first_air_date: String?,
    @Expose
    @SerializedName("origin_country")
    val origin_country: List<String>? = ArrayList(),
    @Expose
    @SerializedName("genre_ids")
    val genre_ids: List<Int>?,
    @Expose
    @SerializedName("original_language")
    val original_language: String,
    @Expose
    @SerializedName("vote_count")
    val vote_count: Int?,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("original_name")
    val original_name: String
)