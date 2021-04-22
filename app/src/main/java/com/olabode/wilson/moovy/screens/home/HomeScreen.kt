package com.olabode.wilson.moovy.screens.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.olabode.wilson.moovy.MainViewModel
import com.olabode.wilson.moovy.screens.Routes
import com.olabode.wilson.moovy.screens.widgets.NonClickSearchBar
import com.olabode.wilson.moovy.screens.widgets.UserAvatar
import com.olabode.wilson.moovy.ui.theme.MoovyTheme
import com.olabode.wilson.moovy.ui.theme.deepBlue
import com.olabode.wilson.moovy.ui.theme.lightBlue

@Composable
fun HomeScreen(navController: NavController, viewModel: MainViewModel) {

    val lazyMovieItems = viewModel.movies.collectAsLazyPagingItems()
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
            UserAvatar(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(16.dp)
                    .size(50.dp, 50.dp),
                profileUrl = ""
            )
            Spacer(modifier = Modifier.padding(16.dp))
            NonClickSearchBar(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White),
                text = "Search movie"
            ) {

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
                navController.navigate("${Routes.DETAIL}/${it.id}")
            }

            Spacer(modifier = Modifier.padding(16.dp))
            SectionHeader(
                sectionTitle = "Top Rated",
                actionTitle = "see all",
                onActionClicked = { /*TODO*/ }
            )
            Spacer(modifier = Modifier.padding(8.dp))
            MovieList(
                movies = lazyMovieItems
            ) {
                navController.navigate("${Routes.DETAIL}/${it.id}")
            }
            Spacer(modifier = Modifier.padding(24.dp))
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    MoovyTheme {
      //  HomeScreen(rememberNavController())
    }
}