package com.olabode.wilson.moovy.api.responses.main

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.olabode.wilson.moovy.models.TvSeries

data class DiscoverTvResponse(
    @Expose
    @SerializedName("page")
    val page: Int,
    @Expose
    @SerializedName("results")
    val results: List<TvSeries>,
    @Expose
    @SerializedName("total_results")
    val total_results: Int,
    @Expose
    @SerializedName("total_pages")
    val total_pages: Int
)