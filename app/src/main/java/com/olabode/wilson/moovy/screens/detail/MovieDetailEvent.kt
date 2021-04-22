package com.olabode.wilson.moovy.screens.detail

sealed class MovieDetailEvent {

    data class GetMovieEvent(
        val id : Int
    ) : MovieDetailEvent()
}
