package com.olabode.wilson.moovy.screens.detail

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olabode.wilson.moovy.models.Cast
import com.olabode.wilson.moovy.screens.widgets.ActorAvatar

@Composable
fun ActorsList(modifier: Modifier = Modifier, actors: List<Cast>, onActorClicked: (Cast) -> Unit) {
    LazyRow(modifier = modifier, content = {
        items(actors.size) { index ->
            ActorAvatar(actor = actors[index])
        }
    })
}