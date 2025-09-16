package com.android.bookcmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.android.bookcmp.presentation.book_list.BookListScreenRoot
import com.android.bookcmp.presentation.book_list.BookListViewmodel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        BookListScreenRoot(
            viewmodel = remember { BookListViewmodel() },
            onBookClicked = {},
        )
    }
}