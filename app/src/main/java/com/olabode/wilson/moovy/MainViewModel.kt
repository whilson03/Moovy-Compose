package com.olabode.wilson.moovy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.olabode.wilson.moovy.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(movieRepository: MovieRepository) : ViewModel() {

    val movies = movieRepository.fetchMovies().cachedIn(viewModelScope)

    val tvSeries = movieRepository.fetchTvSeries().cachedIn(viewModelScope)
}