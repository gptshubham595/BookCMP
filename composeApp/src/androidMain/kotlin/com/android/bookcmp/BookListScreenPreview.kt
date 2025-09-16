package com.android.bookcmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.android.bookcmp.core.domain.Book
import com.android.bookcmp.presentation.book_list.BookListScreen
import com.android.bookcmp.presentation.book_list.BookListState
import com.android.bookcmp.presentation.book_list.sampleBooks
import kotlin.random.Random.Default.nextDouble

@Preview
@Composable
fun BookListScreenPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            BookListScreen(
                state = BookListState(
                    searchResults = sampleBooks
                ),
                onAction = {},
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}