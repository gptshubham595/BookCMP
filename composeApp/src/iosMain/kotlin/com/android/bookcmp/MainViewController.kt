package com.android.bookcmp

import androidx.compose.ui.window.ComposeUIViewController
import com.android.bookcmp.app.App
import com.android.bookcmp.di.initKoin

fun MainViewController() =
    ComposeUIViewController(
        configure = { initKoin() }
    ) {
        App()
    }