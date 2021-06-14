package com.olabode.wilson.moovy.api

import com.olabode.wilson.moovy.api.responses.main.DiscoverMovieResponse
import com.olabode.wilson.moovy.api.responses.main.DiscoverTvResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *   Created by OLABODE WILSON on 7/3/20.
 */
interface DiscoverService {

    @GET("discover/movie?language=en&sort_by=popularity.desc")
    suspend fun fetchDiscoverMovie(@Query("page") page: Int): DiscoverMovieResponse


    @GET("discover/tv?language=en&sort_by=popularity.desc")
    suspend fun fetchDiscoverTv(@Query("page") page: Int): DiscoverTvResponse

}