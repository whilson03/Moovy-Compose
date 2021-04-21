package com.olabode.wilson.moovy.screens.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.olabode.wilson.moovy.ui.theme.MoovyTheme


@Composable
fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp)),
        verticalAlignment = Alignment.CenterVertically
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
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                leadingIconColor = Color.DarkGray,
                textColor = Color.DarkGray
            ),
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))

        )
    }
}

@Composable
fun NonClickSearchBar(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
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
        NonClickSearchBar(text="search") {}
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSearch() {
    MoovyTheme {
        SearchBar("", {}, Modifier)
    }
}