package com.olabode.wilson.moovy.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {


    val currentQueryValue = mutableStateOf("")

    var currentSearchResult: Flow<PagingData<Movie>> = searchRepo("")

    fun searchRepo(queryString: String): Flow<PagingData<Movie>> {
        val lastResult = currentSearchResult
        if (queryString == currentQueryValue.value && lastResult != null) {
            return lastResult
        }
        currentQueryValue.value = queryString
        val newResult: Flow<PagingData<Movie>> = movieRepository
            .searchMovie(query = queryString)
            .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }

    fun onQueryTextChanged(queryString: String) {
        this.currentQueryValue.value = queryString
    }

    fun performSearch() {
        currentSearchResult = searchRepo(currentQueryValue.value)
        Timber.e(currentQueryValue.value)
    }
}