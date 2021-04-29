package com.olabode.wilson.moovy.screens.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String,
    image: ImageVector?,
    bgColor: Color = Color.LightGray,
    textColor: Color = Color.Black,
    iconColor : Color = Color.Black,
    onClick: () -> Unit
) {
    Surface(
        color = bgColor,
        contentColor = bgColor,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Color.LightGray
        ),
        modifier = modifier.clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            image?.let { ic ->
                Icon(
                    imageVector = ic,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape),
                    tint = iconColor
                )
            }

            Text(
                text = text,
                color = textColor,
                style = MaterialTheme.typography.caption
            )
        }
    }
}


@Composable
@Preview
fun PreviewChip() {
    Chip(text = "hello wilson", image = Icons.Rounded.Place) {}
}