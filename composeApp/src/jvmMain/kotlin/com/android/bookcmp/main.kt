package com.android.bookcmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.android.bookcmp.app.App
import com.android.bookcmp.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BookCmp",
        ) {
            App()
        }
    }
}