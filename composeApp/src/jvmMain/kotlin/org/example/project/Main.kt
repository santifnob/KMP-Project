package org.example.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import screens.HomeScreen

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP-Project",
    ) {
        HomeScreen()
    }
}