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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olabode.wilson.moovy.R
import com.olabode.wilson.moovy.ui.theme.MoovyTheme

@Composable
fun ActorAvatar(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .size(width = 50.dp, 50.dp)
                .clip(shape = CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.a1),
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = "firstName",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = Color.LightGray
        )

        Text(
            text = "LastName",
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
fun PreviewHomeScreen() {
    MoovyTheme {
        ActorAvatar()
    }
}