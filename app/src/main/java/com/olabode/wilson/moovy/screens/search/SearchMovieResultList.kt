package com.olabode.wilson.moovy.screens.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.ui.theme.lightBlue


@Composable
fun SearchedMovieResultList(
    modifier: Modifier = Modifier,
    movies: LazyPagingItems<Movie>,
    onMovieClicked: (Movie) -> Unit
) {
    LazyColumn(modifier = modifier, content = {
        items(movies) { movie ->
            SearchedMovieItem(movie = movie!!, bgColor = lightBlue, onMovieClicked)
        }
    })
}