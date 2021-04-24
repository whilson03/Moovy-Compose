package com.olabode.wilson.moovy.api

import com.olabode.wilson.moovy.api.responses.main.CastResponse
import com.olabode.wilson.moovy.api.responses.main.KeywordListResponse
import com.olabode.wilson.moovy.api.responses.main.ReviewListResponse
import com.olabode.wilson.moovy.api.responses.main.VideoListResponse
import com.olabode.wilson.moovy.models.Movie
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *   Created by OLABODE WILSON on 8/28/20.
 */
interface MovieService {

    /**
     * [Movie Keywords](https://developers.themoviedb.org/3/movies/get-movie-keywords)
     *
     * Get the keywords that have been added to a movie.
     *
     * @param [id] Specify the id of movie id.
     *
     * @return [KeywordListResponse] response
     */
    @GET("/3/movie/{movie_id}/keywords")
    suspend fun fetchKeywords(@Path("movie_id") id: Int): KeywordListResponse

    /**
     * [Movie Videos](https://developers.themoviedb.org/3/movies/get-movie-videos)
     *
     * Get the videos that have been added to a movie.
     *
     * @param [id] Specify the id of movie id.
     *
     * @return [VideoListResponse] response
     */
    @GET("/3/movie/{movie_id}/videos")
    suspend fun fetchVideos(@Path("movie_id") id: Int): VideoListResponse

    /**
     * [Movie Reviews](https://developers.themoviedb.org/3/movies/get-movie-reviews)
     *
     * Get the user reviews for a movie.
     *
     * @param [id] Specify the id of movie id.
     *
     * @return [ReviewListResponse] response
     */
    @GET("/3/movie/{movie_id}/reviews")
    suspend fun fetchReviews(@Path("movie_id") id: Int): ReviewListResponse


    @GET("/3/movie/{movie_id}")
    suspend fun fetchMovieDetails(@Path("movie_id") id: Int): Movie


    @GET("/3/movie/{movie_id}/credits")
    suspend fun fetchMovieCast(@Path("movie_id") id: Int): CastResponse


}