package com.olabode.wilson.moovy.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.olabode.wilson.moovy.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(movieRepository: MovieRepository) : ViewModel() {
    val movies = movieRepository.fetchMovies().cachedIn(viewModelScope)
}