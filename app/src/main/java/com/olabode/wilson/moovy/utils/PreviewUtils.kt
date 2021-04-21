package com.olabode.wilson.moovy.utils

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.olabode.wilson.moovy.ui.theme.MoovyTheme


@Composable
internal fun ThemedPreview(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MoovyTheme(darkTheme = darkTheme) {
        Surface {
            content()
        }
    }
}
