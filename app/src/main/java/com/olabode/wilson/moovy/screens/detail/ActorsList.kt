package com.olabode.wilson.moovy.screens.detail

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olabode.wilson.moovy.models.Actor
import com.olabode.wilson.moovy.screens.widgets.ActorAvatar

@Composable
fun ActorsList(modifier: Modifier = Modifier, actors: List<Actor>, onActorClicked: (Actor) -> Unit) {
    LazyRow(modifier = modifier, content = {
        items(actors.size) { index ->
            ActorAvatar()
        }
    })
}


val actors = List(10){
    Actor("Jack8","")
}