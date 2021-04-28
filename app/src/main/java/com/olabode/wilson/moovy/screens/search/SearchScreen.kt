package com.olabode.wilson.moovy.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.olabode.wilson.moovy.screens.widgets.SquircleIconButton


@Composable
fun SearchScreen(onNavigateBack: () -> Unit) {
    SearchScreenContent {
        onNavigateBack()
    }
}

@Composable
fun SearchScreenContent(onNavigateBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            SquircleIconButton(icon = Icons.Rounded.ArrowBack) {
                onNavigateBack()
            }

            SquircleIconButton(icon = Icons.Rounded.Info) {
            }
        }

    }
}