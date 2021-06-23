package com.olabode.wilson.moovy.screens.detail

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.olabode.wilson.moovy.models.Cast
import com.olabode.wilson.moovy.screens.widgets.ActorAvatar
import com.olabode.wilson.moovy.screens.widgets.LoadingActorAvatar
import com.olabode.wilson.moovy.ui.theme.MoovyTheme

@Composable
fun ActorsList(modifier: Modifier = Modifier, actors: List<Cast>, onActorClicked: (Cast) -> Unit) {
    LazyRow(modifier = modifier, content = {
        items(actors.size) { index ->
            ActorAvatar(actor = actors[index], onActorClicked = onActorClicked)
        }
    })
}

@Composable
fun LoadingActorList(modifier: Modifier = Modifier, alpha: Float) {
    LazyRow(modifier = modifier) {
        item { LoadingActorAvatar(alpha = alpha) }
        item { LoadingActorAvatar(alpha = alpha) }
        item { LoadingActorAvatar(alpha = alpha) }
        item { LoadingActorAvatar(alpha = alpha) }
        item { LoadingActorAvatar(alpha = alpha) }
        item { LoadingActorAvatar(alpha = alpha) }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAvatarLoadingList() {
    MoovyTheme {
        LoadingActorList(alpha = 1f)
    }
}