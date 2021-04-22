package com.olabode.wilson.moovy.repository

import androidx.paging.PagingData
import com.olabode.wilson.moovy.models.TvSeries
import com.olabode.wilson.moovy.models.entity.Movie
import kotlinx.coroutines.flow.Flow

/**
 *   Created by OLABODE WILSON on 7/13/20.
 */

interface MovieRepository {

    fun fetchMovies(): Flow<PagingData<Movie>>

    fun fetchTvSeries(): Flow<PagingData<TvSeries>>

   // fun searchMovies(query: String): Flow<PagingData<Movie>>
}