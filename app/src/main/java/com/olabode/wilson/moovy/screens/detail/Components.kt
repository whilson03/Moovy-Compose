package com.olabode.wilson.moovy.screens.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp


@Composable
fun MoreInfoTitle(modifier: Modifier = Modifier, title: String) {
    Text(
        modifier = modifier,
        text = title,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        color = Color.White,
        fontSize = 12.sp
    )
}


@Composable
fun MoreInfoValue(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        color = Color.Gray,
        fontSize = 12.sp
    )
}