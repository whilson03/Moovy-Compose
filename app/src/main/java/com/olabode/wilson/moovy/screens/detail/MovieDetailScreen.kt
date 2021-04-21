package com.olabode.wilson.moovy.screens.detail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olabode.wilson.moovy.R
import com.olabode.wilson.moovy.ui.theme.MoovyTheme
import com.olabode.wilson.moovy.ui.theme.deepBlue


@Composable
fun MovieDetailScreen() {
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
                .height(30.dp)
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 24.dp,
                        bottomStart = 24.dp
                    )
                )

        ) {
            Image(
                painter = painterResource(id = R.drawable.avengers),
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
                Icon(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {  },
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "search movie"
                )

                Icon(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { },
                    imageVector = Icons.Rounded.FavoriteBorder,
                    contentDescription = "search movie"
                )
            }


        }

        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "Movie Title",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray,
            modifier = Modifier.padding(start = 16.dp)
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "Watch Now",
            maxLines = 1,
            modifier = Modifier
                .padding(start = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            text = stringResource(R.string.movie_desc),
            overflow = TextOverflow.Ellipsis,
            maxLines = 4,
            color = Color.LightGray,
            modifier = Modifier.padding(start = 16.dp),
            style = MaterialTheme.typography.body2
        )

        Spacer(modifier = Modifier.padding(8.dp))
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
                MoreInfoValue(text = "2018")
            }
        }
    }
}

@Composable
fun MoreInfoTitle(title: String) {
    Text(
        text = title,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        color = Color.White,
        fontSize = 12.sp
    )
}


@Composable
fun MoreInfoValue(text: String) {
    Text(
        text = text,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        color = Color.Gray,
        fontSize = 12.sp
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    MoovyTheme {
        // MovieDetailScreen()
    }
}