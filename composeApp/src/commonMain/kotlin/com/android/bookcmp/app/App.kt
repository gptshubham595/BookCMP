package com.android.bookcmp.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.android.book_feature.book.presentation.nav.GetBookNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    GetBookNavGraph(navController)

}