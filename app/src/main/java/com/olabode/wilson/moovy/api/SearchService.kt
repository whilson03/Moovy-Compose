package com.olabode.wilson.moovy.api

import com.olabode.wilson.moovy.api.responses.main.MovieSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *   Created by OLABODE WILSON on 8/28/20.
 */
interface SearchService {

    @GET("/3/search/movie")
    suspend fun searchMovie(
        @Query("query") query: String,
        @Query("page") page: Int
    ): MovieSearchResponse
}