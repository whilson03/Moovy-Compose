package com.olabode.wilson.moovy.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.olabode.wilson.moovy.models.Movie
import com.olabode.wilson.moovy.screens.home.HomeViewModel
import com.olabode.wilson.moovy.screens.widgets.SearchBar
import com.olabode.wilson.moovy.screens.widgets.SquircleIconButton
import com.olabode.wilson.moovy.ui.theme.MoovyTheme
import com.olabode.wilson.moovy.ui.theme.deepBlue
import com.olabode.wilson.moovy.ui.theme.lightBlue


@Composable
fun SearchScreen(
    viewModel: HomeViewModel,
    navigateToMovieDetail: (movieId: Int) -> Unit,
    onNavigateBack: () -> Unit
) {
    val lazyMovieItems = viewModel.movies.collectAsLazyPagingItems()

    SearchScreenContent(
        onQueryTextChanged = { },
        navigateToMovieDetail = navigateToMovieDetail,
        onNavigateBack = onNavigateBack,
        lazyMovieItems = lazyMovieItems
    )
}

@Composable
fun SearchScreenContent(
    lazyMovieItems: LazyPagingItems<Movie>,
    onQueryTextChanged: (String) -> Unit,
    navigateToMovieDetail: (movieId: Int) -> Unit,
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(deepBlue)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            SquircleIconButton(icon = Icons.Rounded.ArrowBack, bgColor = lightBlue) {
                onNavigateBack()
            }

            Text(
                text = "Search Moovy",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )

            SquircleIconButton(icon = Icons.Rounded.Info, bgColor = lightBlue) {
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        SearchBar(
            text = "enter movie title",
            onTextChange = onQueryTextChanged,
            bgColor = lightBlue,
            leadingIconColor = Color.White,
            textColor = Color.White,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
                .clip(
                    RoundedCornerShape(
                        CornerSize(16.dp)
                    )
                )
        )


        Spacer(modifier = Modifier.height(16.dp))

        SearchedMovieResultList(movies = lazyMovieItems) {
            navigateToMovieDetail(it.id.toInt())
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen() {
    MoovyTheme {
//        SearchScreenContent({}, {}, {})
    }
}