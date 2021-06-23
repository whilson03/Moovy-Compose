package com.olabode.wilson.moovy.screens.detail

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.olabode.wilson.moovy.screens.widgets.SquircleIconButton
import com.olabode.wilson.moovy.ui.theme.MoovyTheme
import com.olabode.wilson.moovy.ui.theme.deepBlue

@Composable
fun MovieDetailLoadingSkeleton(onBackPressed: () -> Unit) {

    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            repeatMode = RepeatMode.Reverse
        )
    )

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
                .background(Color.LightGray.copy(alpha = alpha))

        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                SquircleIconButton(
                    icon = Icons.Rounded.ArrowBack
                ) {
                    onBackPressed()
                }

                SquircleIconButton(
                    icon = Icons.Rounded.FavoriteBorder
                ) {}
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))

        //movie title
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(30.dp)
                .fillMaxWidth(0.80f)
                .background(Color.LightGray.copy(alpha = alpha))
        )

        Spacer(modifier = Modifier.padding(16.dp))

        // watch now
        Box(
            modifier = Modifier
                .padding(start = 16.dp)
                .width(120.dp)
                .height(30.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray.copy(alpha = alpha))
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.padding(16.dp))

        // overview
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(12.dp)
                .fillMaxWidth()
                .background(Color.LightGray.copy(alpha = alpha))
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(12.dp)
                .fillMaxWidth(0.80f)
                .background(Color.LightGray.copy(alpha = alpha))
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(12.dp)
                .fillMaxWidth(0.90f)
                .background(Color.LightGray.copy(alpha = alpha))
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(12.dp)
                .fillMaxWidth(0.50f)
                .background(Color.LightGray.copy(alpha = alpha))
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(12.dp)
                .fillMaxWidth(0.70f)
                .background(Color.LightGray.copy(alpha = alpha))
        )

        Spacer(modifier = Modifier.padding(8.dp))

        //casts
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(25.dp)
                .width(100.dp)
                .background(Color.LightGray.copy(alpha = alpha))
        )
        Spacer(modifier = Modifier.padding(8.dp))

        // Actors
        LoadingActorList(alpha = alpha)

        Spacer(modifier = Modifier.padding(8.dp))

        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Box(
                    modifier = Modifier
                        .height(12.dp)
                        .fillMaxWidth(0.30f)
                        .background(Color.LightGray.copy(alpha = alpha))
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Box(
                    modifier = Modifier
                        .height(12.dp)
                        .fillMaxWidth(0.25f)
                        .background(Color.LightGray.copy(alpha = alpha))
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Box(
                    modifier = Modifier
                        .height(12.dp)
                        .fillMaxWidth(0.30f)
                        .background(Color.LightGray.copy(alpha = alpha))
                )
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Box(
                    modifier = Modifier
                        .height(12.dp)
                        .fillMaxWidth(0.45f)
                        .background(Color.LightGray.copy(alpha = alpha))
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Box(
                    modifier = Modifier
                        .height(12.dp)
                        .fillMaxWidth(0.60f)
                        .background(Color.LightGray.copy(alpha = alpha))
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Box(
                    modifier = Modifier
                        .height(12.dp)
                        .fillMaxWidth(0.50f)
                        .background(Color.LightGray.copy(alpha = alpha))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoadingScreen() {
    MoovyTheme {
        MovieDetailLoadingSkeleton(){

        }
    }
}