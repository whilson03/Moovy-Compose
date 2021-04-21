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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.olabode.wilson.moovy.R
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.ui.theme.MoovyTheme

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
                painter = painterResource(id = R.drawable.aqua),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
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


@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    MoovyTheme {
        MovieItem(sampleMovie, {})
    }
}val sampleMovie = Movie(2, "Avengers EndGame", 5)
