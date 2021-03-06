package com.olabode.wilson.moovy.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.olabode.wilson.moovy.api.DiscoverService
import com.olabode.wilson.moovy.api.MovieService
import com.olabode.wilson.moovy.api.SearchService
import com.olabode.wilson.moovy.models.Cast
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.models.TvSeries
import com.olabode.wilson.moovy.paging.MovieSource
import com.olabode.wilson.moovy.paging.SearchMovieSource
import com.olabode.wilson.moovy.paging.TvSeriesSource
import com.olabode.wilson.moovy.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 7/13/20.
 */

class MovieRepositoryImpl @Inject constructor(
    private val discoverService: DiscoverService,
    private val movieService: MovieService,
    private val searchService: SearchService,
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

    override fun fetchTvSeries(): Flow<PagingData<TvSeries>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { TvSeriesSource(discoverService) }
        ).flow
    }

    override fun searchMovie(query: String): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { SearchMovieSource(query=query, searchService = searchService) }
        ).flow
    }

    override suspend fun fetchMovieDetails(movieId: Int): Movie {
        return withContext(Dispatchers.IO) {
            movieService.fetchMovieDetails(movieId)
        }
    }

    override suspend fun fetchMovieCasts(movieId: Int): List<Cast> {
        return withContext(Dispatchers.IO) {
            movieService.fetchMovieCast(movieId).cast
        }
    }
}