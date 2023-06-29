package com.example.todolist.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color.White,
    background = DarkGray,
    onBackground = Color.White,
    surface = LightBlue,
    onSurface = DarkGray
)

private val typography = Typography()

@Composable
fun ToDoListTheme(darkTheme: Boolean = true, content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}
