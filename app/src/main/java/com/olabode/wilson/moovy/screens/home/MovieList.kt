package com.olabode.wilson.moovy.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.screens.widgets.MovieItem
import com.olabode.wilson.moovy.screens.widgets.sampleMovie
import com.olabode.wilson.moovy.ui.theme.MoovyTheme


@Composable
fun MovieList(modifier: Modifier = Modifier, movies: List<Movie>, onMovieClicked: (Movie) -> Unit) {
    LazyRow(modifier = modifier, content = {
        items(movies.size) { index ->
            MovieItem(movie = movies[index], onMovieClicked)
        }
    })
}


@Composable
fun SectionHeader(modifier: Modifier = Modifier,sectionTitle: String, actionTitle: String, onActionClicked: () -> Unit) {
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
}


@Preview(showBackground = true)
@Composable
fun PreviewSectionHeader() {
    MoovyTheme {
        SectionHeader(Modifier,
            sectionTitle = "Recommended",
            actionTitle = "see more",
            onActionClicked = { /*TODO*/ })
    }
}

val movies = List(10){
    sampleMovie
}