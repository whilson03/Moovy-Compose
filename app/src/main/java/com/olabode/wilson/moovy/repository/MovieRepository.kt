package com.olabode.wilson.moovy.repository

import androidx.paging.PagingData
import com.olabode.wilson.moovy.models.Cast
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.models.TvSeries
import kotlinx.coroutines.flow.Flow

/**
 *   Created by OLABODE WILSON on 7/13/20.
 */

interface MovieRepository {

    fun fetchMovies(): Flow<PagingData<Movie>>

    fun fetchTvSeries(): Flow<PagingData<TvSeries>>

    fun searchMovie(query: String): Flow<PagingData<Movie>>

    suspend fun fetchMovieDetails(movieId: Int): Movie

    suspend fun fetchMovieCasts(movieId: Int): List<Cast>

}