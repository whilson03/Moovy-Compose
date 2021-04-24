package com.olabode.wilson.moovy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.olabode.wilson.moovy.screens.ScreenNavigator
import com.olabode.wilson.moovy.ui.theme.MoovyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoovyTheme {
                ScreenNavigator()
            }
        }
    }
}