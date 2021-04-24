package com.olabode.wilson.moovy.screens.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olabode.wilson.moovy.models.Cast
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

const val MOVIE_KEY = "MOVIE_KEY"

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val movie: MutableState<Movie?> = mutableStateOf(null)

    val casts: MutableState<List<Cast>> = mutableStateOf(emptyList())

    val loading = mutableStateOf(false)

    init {
        savedStateHandle.get<Int>(MOVIE_KEY)?.let { movieId ->
            onTriggerEvent(MovieDetailEvent.GetMovieEvent(movieId))
        }
    }

    fun onTriggerEvent(event: MovieDetailEvent) {
        viewModelScope.launch {
            try {
                when (event) {
                    is MovieDetailEvent.GetMovieEvent -> {
                        if (movie.value == null) {
                            fetchMovieDetails(event.id)
                        }
                    }

                    is MovieDetailEvent.GetMovieCast -> {
                        if (casts.value.isEmpty()) {
                            fetchMovieCasts(event.id)
                        }
                    }
                }
            } catch (e: Exception) {
                Timber.e(e.cause)
            }
        }
    }

    private suspend fun fetchMovieCasts(id: Int) {
        val casts = movieRepository.fetchMovieCasts(id)
        this.casts.value = casts
    }

    private suspend fun fetchMovieDetails(id: Int) {
        loading.value = true
        val movie = movieRepository.fetchMovieDetails(id)
        this.movie.value = movie
        savedStateHandle.set(MOVIE_KEY, movie.id)
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("MOVIE DETAIL VIEWMODEL CLEARED")
    }
}