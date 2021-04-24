package com.olabode.wilson.moovy.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import com.olabode.wilson.moovy.data.actors
import androidx.compose.ui.layout.ContentScale
import com.olabode.wilson.moovy.ui.theme.MoovyTheme
import com.olabode.wilson.moovy.utils.ImagesUtils
import com.olabode.wilson.moovy.models.Cast

@Composable
fun ActorAvatar(
    modifier: Modifier = Modifier,
    actor: Cast
) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .size(width = 80.dp, 80.dp)
                .clip(shape = CircleShape)
        ) {
            Image(
                painter =  rememberCoilPainter(
                    request = ImagesUtils.getBackdropPath(actor.profile_path ?: "") ,
                    shouldRefetchOnSizeChange = { _, _ -> false },
                ),
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = actor.original_name.take(20),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            style = androidx.compose.ui.text.TextStyle(

            )
        )

        Text(
            text = actor.character.take(20),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = Color.LightGray
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAvatarScreen() {
    MoovyTheme {
        ActorAvatar(actor = actors[0])
    }
}