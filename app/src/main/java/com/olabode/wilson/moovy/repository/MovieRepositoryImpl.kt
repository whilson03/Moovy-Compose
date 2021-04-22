package com.olabode.wilson.moovy.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.olabode.wilson.moovy.api.DiscoverService
import com.olabode.wilson.moovy.api.SearchService
import com.olabode.wilson.moovy.models.entity.Movie
import com.olabode.wilson.moovy.paging.MovieSource
import com.olabode.wilson.moovy.utils.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 7/13/20.
 */

class MovieRepositoryImpl @Inject constructor(
    private val discoverService: DiscoverService,
    private val searchService: SearchService,
    private val movieSource: MovieSource
) : MovieRepository {

    override fun fetchMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MovieSource(discoverService) }
        ).flow
    }
}