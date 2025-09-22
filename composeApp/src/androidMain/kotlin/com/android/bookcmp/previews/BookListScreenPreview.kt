package com.android.bookcmp.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.android.bookcmp.book.domain.Book
import com.android.bookcmp.book.presentation.book_list.BookListScreen
import com.android.bookcmp.book.presentation.book_list.BookListState
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

val sampleBooks = (1..10).map {
    Book(
        id = it.toString(),
        title = "Sample Book Title $it",
        authors = listOf("Author One", "Author Two"),
        description = "This is a sample description of the book. It provides an overview of the content.",
        imageUrl = "https://via.placeholder.com/150",
        firstPublishYear = "2020",
        pageCount = 200,
        averageRating = nextDouble(1.0, 5.0),
        ratingsCount = 100,
        language = listOf("eng"),
        numEditions = 1
    )
}