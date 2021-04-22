package com.olabode.wilson.moovy.api.responses.main


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.olabode.wilson.moovy.models.Genres

/**
 *   Created by OLABODE WILSON on 8/1/20.
 */
data class GenresResponse(

    @Expose
    @SerializedName("genres")
    var genres: List<Genres>
)