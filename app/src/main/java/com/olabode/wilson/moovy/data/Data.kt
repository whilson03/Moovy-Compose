package com.olabode.wilson.moovy.data

import com.olabode.wilson.moovy.models.Cast
import com.olabode.wilson.moovy.models.Movie

val sample_movie = Movie(
    id = 1,
    page = 3,
    overview = "",
    original_language = "",
    original_title = "Avengers",
    title = "Avengers",
    popularity = 0f,
    vote_average = 0f,
    vote_count = 0,
    adult = false,
    release_date = "12-08-2020",
    video = false,
    backdrop_path = "",
    poster_path = "",
    keywords = arrayListOf(),
    reviews = arrayListOf(),
    videos = arrayListOf(),
    genre_ids = arrayListOf()
)


val actors = List(10){
    Cast(1,"wilson","", "olabode")
}