package com.olabode.wilson.moovy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.olabode.wilson.moovy.screens.home.HomeScreen
import com.olabode.wilson.moovy.ui.theme.MoovyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoovyTheme {
                HomeScreen()
            }
        }
    }
}

