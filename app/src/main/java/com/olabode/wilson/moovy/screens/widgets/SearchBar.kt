package com.olabode.wilson.moovy.screens.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.olabode.wilson.moovy.ui.theme.MoovyTheme


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    bgColor: Color = Color.White,
    textColor: Color = Color.DarkGray,
    focusedIndicatorColor: Color = Color.Transparent,
    unfocusedIndicatorColor: Color = Color.Transparent,
    leadingIconColor: Color = Color.DarkGray,
    onTextChange: (String) -> Unit
) {

    TextField(
        value = if (text.isNotEmpty()) text else "Search",
        onValueChange = onTextChange,


        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "search movie"
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = focusedIndicatorColor,
            unfocusedIndicatorColor = unfocusedIndicatorColor,
            leadingIconColor = leadingIconColor,
            textColor = textColor
        ),
        maxLines = 1,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(colors = listOf(bgColor, bgColor)),
                RectangleShape,
                0.5f
            )
    )

}

@Composable
fun SearchBarItem(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Box(modifier = modifier.height(40.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White)
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.width(16.dp))
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search"
            )
            Spacer(Modifier.width(16.dp))
            Text(text = text)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewNonClickSearch() {
    MoovyTheme {
        SearchBarItem(text = "search") {}
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSearch() {
    MoovyTheme {
        SearchBar(text = "", onTextChange = {})
    }
}