package com.android.bookcmp.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.android.book_feature.book.domain.Book
import com.android.book_feature.book.presentation.book_list.components.BookListItem

@Preview
@Composable
fun BookListItemPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            BookListItem(
                book = Book(
                    id = "1",
                    title = "Sample Book Title",
                    authors = listOf("Author One", "Author Two"),
                    description = "This is a sample description of the book. It provides an overview of the content.",
                    imageUrl = "https://via.placeholder.com/150",
                    firstPublishYear = "2020",
                    pageCount = 200,
                    averageRating = 5.0,
                    ratingsCount = 100,
                    language = listOf("eng"),
                    numEditions = 1
                ),
                {},
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}