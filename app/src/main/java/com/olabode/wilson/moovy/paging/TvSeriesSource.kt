package com.olabode.wilson.moovy.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.olabode.wilson.moovy.api.DiscoverService
import com.olabode.wilson.moovy.models.TvSeries
import com.olabode.wilson.moovy.models.entity.Movie
import com.olabode.wilson.moovy.utils.Constants
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class TvSeriesSource @Inject constructor(
    private val discoverService: DiscoverService
) : PagingSource<Int, TvSeries>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvSeries> {
        val position = params.key ?: 1

        return try {
            val response = discoverService.fetchDiscoverTv(position)
            Timber.e(response.toString())
            val movies = response.results
            val nextKey = if (movies.isEmpty()) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                position + (params.loadSize / Constants.NETWORK_PAGE_SIZE)
            }
            LoadResult.Page(
                data = movies,
                prevKey = if (position == 1) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    // The refresh key is used for subsequent refresh calls to PagingSource.load after the initial load
    override fun getRefreshKey(state: PagingState<Int, TvSeries>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}