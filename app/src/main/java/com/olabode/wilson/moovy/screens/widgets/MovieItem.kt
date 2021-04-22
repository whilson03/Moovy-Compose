package com.olabode.wilson.moovy.screens.widgets

import androidx.compose.foundation.Image
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
import com.olabode.wilson.moovy.models.TvSeries
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.ui.theme.MoovyTheme
import com.olabode.wilson.moovy.utils.ImagesUtils

@Composable
fun MovieItem(movie: Movie, onMovieClicked: (Movie) -> Unit) {
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
            text = tvSeries.original_name?:"",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )


    }
}


@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    MoovyTheme {
        // MovieItem(, {})
    }
}
