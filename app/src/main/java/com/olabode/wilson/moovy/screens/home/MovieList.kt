package com.olabode.wilson.moovy.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.models.TvSeries
import com.olabode.wilson.moovy.screens.widgets.MovieItem
import com.olabode.wilson.moovy.screens.widgets.TvSeriesItem
import com.olabode.wilson.moovy.ui.theme.MoovyTheme


@Composable
fun MovieList(
    modifier: Modifier = Modifier,
    movies: LazyPagingItems<Movie>,
    state: LazyListState = rememberLazyListState(),
    onMovieClicked: (Movie) -> Unit
) {
    LazyRow(modifier = modifier, state = state, content = {
        items(movies) { movie ->
            MovieItem(movie = movie!!, onMovieClicked)
        }
    })
}

@Composable
fun TvSeriesList(
    modifier: Modifier = Modifier,
    tvSeries: LazyPagingItems<TvSeries>,
    onMovieClicked: (TvSeries) -> Unit
) {
    LazyRow(modifier = modifier, content = {
        items(tvSeries) { movie ->
            TvSeriesItem(tvSeries = movie!!, onMovieClicked)
        }
    })
}


@Composable
fun Section(
    modifier: Modifier = Modifier,
    sectionTitle: String,
    actionTitle: String,
    onActionClicked: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = sectionTitle.toUpperCase(),
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                color = Color.White
            )

            Text(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .clickable { onActionClicked() },
                text = actionTitle.toLowerCase(),
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                letterSpacing = 0.5.sp,
                color = Color.LightGray
            )
        }
        Spacer(modifier = modifier.height(8.dp))
        content()
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewSectionHeader() {
    MoovyTheme {
        Section(Modifier,
            sectionTitle = "Recommended",
            actionTitle = "see more",
            onActionClicked = { /*TODO*/ }) {

        }
    }
}
