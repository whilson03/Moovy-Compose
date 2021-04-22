package com.olabode.wilson.moovy.api.responses.main

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.olabode.wilson.moovy.models.Movie

data class MovieSearchResponse(
    @Expose @SerializedName("total_results") val totalResult: Int = 0,
    @Expose @SerializedName("total_pages") val totalPages: Int = 0,
    @Expose @SerializedName("results") val items: List<Movie> = emptyList()
)
