package com.olabode.wilson.moovy.api

import com.olabode.wilson.moovy.api.responses.main.DiscoverMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *   Created by OLABODE WILSON on 7/3/20.
 */
interface DiscoverService {
    /**
     * [Movie Discover](https://developers.themoviedb.org/3/discover/movie-discover)
     *
     *  Discover movies by different types of data like average rating, number of votes, genres and certifications.
     *  You can get a valid list of certifications from the  method.
     *
     *  @param [page] Specify the page of results to query.
     *
     *  @return [DiscoverMovieResponse] response
     */
    @GET("discover/movie?language=en&sort_by=popularity.desc")
    suspend fun fetchDiscoverMovie(@Query("page") page: Int): DiscoverMovieResponse


    @GET("discover/tv?language=en&sort_by=popularity.desc")
    suspend fun fetchDiscoverTv(@Query("page") page: Int): DiscoverMovieResponse

}