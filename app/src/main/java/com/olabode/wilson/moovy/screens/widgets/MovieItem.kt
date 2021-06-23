package com.olabode.wilson.moovy.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.olabode.wilson.moovy.data.sample_movie
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.models.TvSeries
import com.olabode.wilson.moovy.ui.theme.MoovyTheme
import com.olabode.wilson.moovy.ui.theme.amber
import com.olabode.wilson.moovy.ui.theme.deepGreen
import com.olabode.wilson.moovy.ui.theme.deepRed
import com.olabode.wilson.moovy.utils.ImagesUtils

private fun getColorForRating(value: Float = 0f): Color {
    return when {
        value >= 7 -> deepGreen
        value >= 5 -> amber
        else -> deepRed
    }
}

@Composable
fun MovieItem(
    movie: Movie,
    onMovieClicked: (Movie) -> Unit
) {
    Column(
        Modifier
            .padding(4.dp)
            .width(130.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable { onMovieClicked(movie) }
    ) {
        Box(
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(16.dp))

        ) {
            Image(
                painter = rememberCoilPainter(
                    request = ImagesUtils.getBackdropPath(movie.backdrop_path ?: ""),
                    shouldRefetchOnSizeChange = { _, _ -> false },
                ),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        }
        Spacer(Modifier.height(8.dp))

        Text(
            text = movie.title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
        Spacer(Modifier.height(2.dp))

        Text(
            text = movie.vote_average.toString(),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .padding(start = 8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color = getColorForRating(movie.vote_average))
                .padding(start = 8.dp, end = 8.dp),
            color = Color.White
        )
        Spacer(Modifier.height(4.dp))
    }
}


@Composable
fun TvSeriesItem(tvSeries: TvSeries, onMovieClicked: (TvSeries) -> Unit) {
    Column(
        Modifier
            .padding(4.dp)
            .width(130.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable { onMovieClicked(tvSeries) }
    ) {
        Box(
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(16.dp))

        ) {
            Image(
                painter = rememberCoilPainter(
                    request = ImagesUtils.getBackdropPath(tvSeries.backdrop_path ?: ""),
                    shouldRefetchOnSizeChange = { _, _ -> false },
                ),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        }
        Spacer(Modifier.height(8.dp))

        Text(
            text = tvSeries.original_name ?: "",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )

        Spacer(Modifier.height(2.dp))

        Text(
            text = tvSeries.vote_average.toString(),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .padding(start = 8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color = getColorForRating(tvSeries.vote_average ?: 0f))
                .padding(start = 8.dp, end = 8.dp),
            color = Color.White
        )
        Spacer(Modifier.height(4.dp))

    }
}


@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    MoovyTheme {
        MovieItem(sample_movie) {}
    }
}
