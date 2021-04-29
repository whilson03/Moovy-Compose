package com.olabode.wilson.moovy.screens.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.olabode.wilson.moovy.data.sample_movie
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.screens.widgets.Chip
import com.olabode.wilson.moovy.ui.theme.deepBlue
import com.olabode.wilson.moovy.ui.theme.goldenYellow
import com.olabode.wilson.moovy.ui.theme.lightBlue
import com.olabode.wilson.moovy.utils.ImagesUtils

@Composable
fun SearchedMovieItem(
    movie: Movie,
    bgColor: Color,
    onClick: (Movie) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(8.dp)
            .clickable { onClick(movie) }
    ) {
        Image(
            painter = rememberCoilPainter(
                request = ImagesUtils
                    .getBackdropPath(movie.backdrop_path ?: ""),
                shouldRefetchOnSizeChange = { _, _ -> false },
            ),
            contentDescription = "",
            modifier = Modifier
                .fillMaxHeight()
                .width(120.dp)
                .clip(CutCornerShape(
                    16.dp
                )),
            contentScale = ContentScale.Crop,
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
                .clip(RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp))
                .background(
                    brush = Brush.horizontalGradient(colors = listOf(bgColor, bgColor)),
                    RectangleShape,
                    0.5f
                ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {

                Text(
                    text = movie.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = Color.White,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Chip(
                    text = movie.vote_average.toString(),
                    image = Icons.Rounded.Star,
                    iconColor = goldenYellow,
                    textColor = Color.White,
                    bgColor = deepBlue
                ) {

                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewSearchedMovieItem() {
    SearchedMovieItem(movie = sample_movie, bgColor = lightBlue) {}
}