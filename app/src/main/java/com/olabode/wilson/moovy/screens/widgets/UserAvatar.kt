package com.olabode.wilson.moovy.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.olabode.wilson.moovy.ui.theme.MoovyTheme


@Composable
fun UserAvatar(modifier: Modifier, profileUrl: String) {
    Box(
        modifier = modifier
            .size(40.dp, 40.dp)
            .border(
                width = 2.dp,
                color = Color.White,
                shape = CircleShape
            )
            .clip(shape = CircleShape)


    ) {
        Image(
            painter = rememberCoilPainter(
                request = profileUrl,
                shouldRefetchOnSizeChange = { _, _ -> false },
            ),
            contentDescription = ""
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewUserAvatarScreen() {
    MoovyTheme {
        UserAvatar(Modifier, profileUrl = "")
    }
}