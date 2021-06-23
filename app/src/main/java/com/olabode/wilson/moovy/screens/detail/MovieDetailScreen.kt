package com.olabode.wilson.moovy.screens.detail


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import com.olabode.wilson.moovy.data.actors
import com.olabode.wilson.moovy.data.sample_movie
import com.olabode.wilson.moovy.models.Cast
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.screens.widgets.SquircleIconButton
import com.olabode.wilson.moovy.ui.theme.MoovyTheme
import com.olabode.wilson.moovy.ui.theme.deepBlue
import com.olabode.wilson.moovy.utils.ImagesUtils


@Composable
fun MovieDetailScreen(
    movieId: Int,
    viewModel: MovieDetailViewModel,
    onNavigateBack: () -> Unit
) {
    viewModel.onTriggerEvent(MovieDetailEvent.GetMovieEvent(movieId))
    viewModel.onTriggerEvent(MovieDetailEvent.GetMovieCast(movieId))

    val loading = viewModel.loading.value
    val movie = viewModel.movie.value
    val casts = viewModel.casts.value

    if (loading) {
        MovieDetailLoadingSkeleton{
            onNavigateBack()
        }
    } else {
        movie?.let {
            MovieDetailContent(movie = it, casts) {
                onNavigateBack()
            }
        }
    }

}

@Composable
private fun MovieDetailContent(
    movie: Movie,
    actors: List<Cast>,
    onBackPressed: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(deepBlue)
            .verticalScroll(rememberScrollState())
    ) {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 24.dp,
                        bottomStart = 24.dp
                    )
                )

        ) {
            Image(
                painter = rememberCoilPainter(
                    request = ImagesUtils.getBackdropPath(movie.backdrop_path ?: ""),
                    shouldRefetchOnSizeChange = { _, _ -> false },
                ),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                SquircleIconButton(icon = Icons.Rounded.ArrowBack) {
                    onBackPressed()
                }

                SquircleIconButton(icon = Icons.Rounded.FavoriteBorder) {
                }
            }


        }

        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = movie.title,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray,
            modifier = Modifier.padding(start = 16.dp)
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Watch Now",
                maxLines = 1,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.LightGray)
                    .padding(8.dp)
            )



        }

        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            text = movie.overview,
            overflow = TextOverflow.Ellipsis,
            maxLines = 8,
            color = Color.LightGray,
            modifier = Modifier.padding(start = 16.dp),
            style = MaterialTheme.typography.body2,

            )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "Casts",
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp),
            color = Color.White,
            fontWeight = FontWeight.Medium
        )

        ActorsList(
            actors = actors,
            onActorClicked = { /*TODO*/ },
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.padding(8.dp))

        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                MoreInfoTitle(title = "Studio")
                Spacer(modifier = Modifier.padding(1.dp))
                MoreInfoTitle(title = "Genre")
                Spacer(modifier = Modifier.padding(1.dp))
                MoreInfoTitle(title = "Release")
            }

            Column(modifier = Modifier.padding(16.dp)) {
                MoreInfoValue(text = "Warner Bros")
                Spacer(modifier = Modifier.padding(1.dp))
                MoreInfoValue(text = "Action, Adventure, Fantasy")
                Spacer(modifier = Modifier.padding(1.dp))
                MoreInfoValue(text = movie.release_date)
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    MoovyTheme {
        MovieDetailContent(sample_movie, actors = actors) {}
    }
}