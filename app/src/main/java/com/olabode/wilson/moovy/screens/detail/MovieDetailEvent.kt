package com.olabode.wilson.moovy.screens.detail

sealed class MovieDetailEvent {

    data class GetMovieEvent(
        val id: Int
    ) : MovieDetailEvent()


    data class GetMovieCast(
        val id: Int
    ) : MovieDetailEvent()
}
