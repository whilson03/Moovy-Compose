package com.olabode.wilson.moovy.screens.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.models.TvSeries
import com.olabode.wilson.moovy.screens.widgets.SearchBarItem
import com.olabode.wilson.moovy.screens.widgets.UserAvatar
import com.olabode.wilson.moovy.ui.theme.MoovyTheme
import com.olabode.wilson.moovy.ui.theme.deepBlue
import com.olabode.wilson.moovy.ui.theme.lightBlue
import com.olabode.wilson.moovy.utils.Constants

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navigateToMovieDetail: (movieId: Int) -> Unit,
    navigateToSearchScreen: () -> Unit
) {
    val lazyMovieItems = viewModel.movies.collectAsLazyPagingItems()
    val lazyTvSeriesItems = viewModel.tvSeries.collectAsLazyPagingItems()

    HomeScreenContent(
        lazyMovieItems,
        lazyTvSeriesItems,
        navigateToMovieDetail,
        navigateToSearchScreen
    )
}


@Composable
private fun HomeScreenContent(
    lazyMovieItems: LazyPagingItems<Movie>,
    lazyTvSeriesItems: LazyPagingItems<TvSeries>,
    navigateToMovieDetail: (movieId: Int) -> Unit,
    navigateToSearchScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightBlue)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.30f)

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = buildAnnotatedString {

                        withStyle(
                            style =
                            SpanStyle(
                                color = Color.White
                            )
                        ) {
                            append("M")
                        }

                        withStyle(
                            style =
                            SpanStyle(
                                color = deepBlue,
                                fontStyle = FontStyle.Italic
                            )
                        ) {
                            append("OO")
                        }
                        withStyle(
                            style =
                            SpanStyle(
                                color = deepBlue
                            )
                        ) {
                            append("VY")
                        }

                    },
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp),
                )

                UserAvatar(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(50.dp, 50.dp),
                    profileUrl = Constants.PROFILE_URL
                )
            }

            Spacer(modifier = Modifier.padding(16.dp))
            SearchBarItem(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White),
                text = "Search movie"
            ) {
                navigateToSearchScreen()
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(
                    RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp
                    )
                )
                .background(deepBlue)
                .verticalScroll(state = rememberScrollState())

        ) {
            Spacer(modifier = Modifier.padding(20.dp))

            SectionHeader(
                sectionTitle = "Recommended",
                actionTitle = "see all",
                onActionClicked = { /*TODO*/ }
            )
            Spacer(modifier = Modifier.padding(8.dp))
            MovieList(
                movies = lazyMovieItems
            ) {
                navigateToMovieDetail(it.id.toInt())
            }

            Spacer(modifier = Modifier.padding(16.dp))
            SectionHeader(
                sectionTitle = "Tv Series",
                actionTitle = "see all",
                onActionClicked = { /*TODO*/ }
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TvSeriesList(
                tvSeries = lazyTvSeriesItems
            ) {
                navigateToMovieDetail(it.id!!)
            }
            Spacer(modifier = Modifier.padding(24.dp))
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    MoovyTheme {
        ///  HomeScreenContent(rememberNavController())
    }
}